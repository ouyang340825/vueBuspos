package com.njty.buspos.controller;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.entity.SysUserEntity;
import com.njty.buspos.service.SysUserService;
import com.njty.buspos.utils.Constants;
import com.njty.buspos.utils.MD5;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    protected static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private EhCacheManager ecm;


    /**
     *系统用户管理---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getSysUserList")
    public MsgBean getSysUserList(@RequestParam Map<String,Object> params){
        logger.info("SysUserController =====================> getSysUserList");
        return sysUserService.getSysUserList2(params);
    }


    /**
     *系统用户管理---新增
     * @param params
     * @return
     */
    @RequestMapping(value = "/addSysUser")
    public MsgBean addSysUser(@RequestParam Map<String,Object> params){
        logger.info("SysUserController =====================> addSysUser");
        return sysUserService.addSysUser(params);
    }


    /**
     *系统用户管理---新增
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/addSysUser2")
    public MsgBean addSysUser2(@RequestBody SysUserEntity sysUser){
        logger.info("SysUserController =====================> addSysUser2");
        return sysUserService.addSysUser2(sysUser);
    }


    /**
     *系统用户管理---修改
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/modSysUser")
    public MsgBean modSysUser(@RequestBody SysUserEntity sysUser){
        logger.info("SysUserController =====================> modSysUser");
        return sysUserService.modSysUser(sysUser);
    }

    /**
     *修改密码
     * @param params
     * @return
     */
    @RequestMapping(value = "/changePwd")
    public MsgBean changePwd(@RequestParam Map<String,Object> params){
        logger.info("SysUserController =====================> changePwd");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        String oldPassword = params.get("oldPassword").toString();
        String md5OldPW = MD5.MD5Encode(oldPassword);
        if(md5OldPW.equals(existUser.getPassword())){
            String newPassword = params.get("newPassword").toString();
            String md5NewPW = MD5.MD5Encode(newPassword);
            params.put("PASSWORD",md5NewPW);
            params.put("ID",existUser.getId());
            return sysUserService.changePwd(params);
        }else{
            MsgBean msgBean = new MsgBean();
            msgBean.setMsg("原密码输入错误,请重新输入");
            return msgBean;
        }
    }


    /**
     *系统用户管理---删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delSysUserList")
    //@RequiresPermissions(value="usermanage")
    public MsgBean delSysUserList(@RequestBody String[] id){
        logger.info("SysUserController =====================> delSysUserList");
        return sysUserService.delSysUserList(id);
    }




    @RequestMapping(value = "/userLogin", method= RequestMethod.POST)
    @ResponseBody
    public MsgBean login(@RequestBody SysUserEntity sysUser,
                         @RequestParam(value = "rememberMe", required = false) boolean rememberMe) {
        logger.debug("用户登录，请求参数=sysUser:" + sysUser + "，是否记住我：" + rememberMe);
        MsgBean msgBean = new MsgBean();
        if (null == sysUser) {
            msgBean.setMsg("请求参数有误，请您稍后再试");
            logger.debug("用户登录，结果=请求参数有误，请您稍后再试");
            return msgBean;
        }
        // 用户是否存在

        SysUserEntity existUser = this.sysUserService.findUserByUsername(sysUser.getUsername());
        if (existUser == null) {
            msgBean.setMsg("用户名或密码不正确");
            logger.debug("用户登录，结果:用户名不存在");
            return msgBean;
        } else {
            // 是否离职
            if (existUser.getIsJob().equals("1")) {
                msgBean.setMsg("登录用户已离职，请您联系管理员");
                logger.debug("用户登录，结果:登录用户已离职，请您联系管理员");
                return msgBean;
            }
        }
        // 用户登录
        try {
            // 1、 封装用户名、密码、是否记住我到token令牌对象 [支持记住我]
            AuthenticationToken token = new UsernamePasswordToken(sysUser.getUsername(), DigestUtils.md5Hex(sysUser.getPassword()),rememberMe);
            // 2、 Subject调用login
            Subject subject = SecurityUtils.getSubject();
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.debug("用户登录，用户验证开始！sysUser=" + sysUser.getUsername());
            subject.login(token);
            msgBean.setSuccess(Constants.GLOBAL_MSG_BOOL_SUCCESS);
            logger.info("用户登录，用户验证通过！sysUser=" + sysUser.getUsername());
        } catch (UnknownAccountException uae) {
            logger.error("用户登录，用户验证未通过：未知用户！sysUser=" + sysUser.getUsername(), uae);
            msgBean.setMsg("用户名或密码不正确");
        } catch (IncorrectCredentialsException ice) {
            // 获取输错次数
            logger.error("用户登录，用户验证未通过：错误的凭证，密码输入错误！sysUser=" + sysUser.getUsername(),ice);
            msgBean.setMsg("用户名或密码不正确");
        } catch (LockedAccountException lae) {
            logger.error("用户登录，用户验证未通过：账户已锁定！sysUser=" + sysUser.getUsername(), lae);
            msgBean.setMsg("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.error("用户登录，用户验证未通过：错误次数大于5次,账户已锁定！sysUser=.getUsername()" + sysUser, eae);
            msgBean.setMsg("用户名或密码错误次数大于5次,账户已锁定!</br><span style='color:red;font-weight:bold; '>2分钟后可再次登录，或联系管理员解锁</span>");
            // 这里结合了，另一种密码输错限制的实现，基于redis或mysql的实现；也可以直接使用RetryLimitHashedCredentialsMatcher限制5次
        }catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("用户登录，用户验证未通过：认证异常，异常信息如下！sysUser=" + sysUser.getUsername(), ae);
            msgBean.setMsg("用户名或密码不正确");
        } catch (Exception e) {
            logger.error("用户登录，用户验证未通过：操作异常，异常信息如下！sysUser=" + sysUser.getUsername(), e);
            msgBean.setMsg("用户登录失败，请您稍后再试");
        }
        Cache<String, AtomicInteger> passwordRetryCache = ecm.getCache("passwordRetryCache");
        if (null != passwordRetryCache) {
            int retryNum = (passwordRetryCache.get(existUser.getUsername()) == null ? 0 : passwordRetryCache.get(existUser.getUsername())).intValue();
            logger.debug("输错次数：" + retryNum);
            if (retryNum > 0 && retryNum < 6) {
                msgBean.setMsg("用户名或密码错误" + retryNum + "次,再输错" + (6 - retryNum) + "次账号将锁定");
            }
        }
        logger.debug("用户登录，sysUser=" + sysUser.getUsername() + ",登录结果=msgBean:" + msgBean);
        return msgBean;
    }


    @RequestMapping(value = "/logout", method= RequestMethod.POST)
    @ResponseBody
    public MsgBean logout() {
        Subject sysUser = SecurityUtils.getSubject();
        logger.debug("用户退出登录,sysUser:" + sysUser);
        sysUser.logout();
        MsgBean msgBean = new MsgBean();
        msgBean.setSuccess(true);
        msgBean.setMsg("退出登录成功");
        return msgBean;
    }

    /**
     *锁屏解锁
     * @param params
     * @return
     */
    @RequestMapping(value = "/unlock")
    public MsgBean unlock(@RequestParam Map<String,Object> params){
        MsgBean msgBean = new MsgBean();
        String password = params.get("password").toString();
        String md5PW = MD5.MD5Encode(password);
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        if(md5PW.equals(existUser.getPassword())){
            msgBean.setSuccess(true);
            msgBean.setMsg("密码正确");
        }
        return msgBean;
    }


    /**
     *获取用户头像
     * @param
     * @return
     */
    @RequestMapping(value = "/getHeadImg")
    public Map getHeadImg(){
        logger.info("SysUserController =====================> getHeadImg");
        Map map = new HashMap();
//        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//        map.put("headImg",existUser.getHeadImg());
        return map;
    }


    public static void main(String[] args) {
        String dsad = DigestUtils.md5Hex("11111");
        System.out.println("dsad = " + dsad);
    }











}
