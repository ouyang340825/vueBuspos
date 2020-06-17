package com.njty.buspos.controller;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.bean.TreeMsgBean;
import com.njty.buspos.entity.SysUserEntity;
import com.njty.buspos.entity.TreeEntity;
import com.njty.buspos.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    protected static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    private SysMenuService sysMenuService;


    /**
     *获取上面横目录
     * @param params
     * @return
     */
    @RequestMapping(value = "/getTopMenuTreeList")
    public List<Map<String,Object>> getTopMenuTreeList(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> getTopMenuTreeList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        String ROLEID = existUser.getRoleId();
        params.put("ROLEID",ROLEID);
        return sysMenuService.getTopMenuTreeList(params);
    }


    /**
     *获取左侧目录
     * @param params
     * @return
     */
    @RequestMapping(value = "/getLeftMenuTreeList")
    public List<TreeEntity> getLeftMenuTreeList(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> getLeftMenuTreeList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        String ROLEID = existUser.getRoleId();
        params.put("ROLEID",ROLEID);
        return sysMenuService.getLeftMenuTreeList(params);
    }

    /**
     *获取所有目录
     * @param params
     * @return
     */
    @RequestMapping(value = "/getAllMenuTreeList")
    public List<TreeEntity> getAllMenuTreeList(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> getAllMenuTreeList");
        return sysMenuService.getAllMenuTreeList(params);
    }


    /**
     *目录管理---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getMenuList")
    public TreeMsgBean getMenuList(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> getMenuList");
        return sysMenuService.getMenuList(params);
    }


    /**
     *目录管理---新增
     * @param params
     * @return
     */
    @RequestMapping(value = "/addMenu")
    public MsgBean addMenu(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> addMenu");
        return sysMenuService.addMenu(params);
    }


    /**
     *目录管理---修改
     * @param params
     * @return
     */
    @RequestMapping(value = "/modMenu")
    public MsgBean modMenu(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> modMenu");
        return sysMenuService.modMenu(params);
    }


    /**
     *目录管理---删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delMenuList")
    public MsgBean delMenuList(@RequestBody String[] id){
        logger.info("SysMenuController =====================> delMenuList");
        return sysMenuService.delMenuList(id);
    }


    /**
     *根据用户id获取菜单目录id
     * @param params
     * @return
     */
    @RequestMapping(value = "/getSelectMenuIdByRoleId")
    public MsgBean getSelectMenuIdByRoleId(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> getSelectMenuIdByRoleId");
        return sysMenuService.getSelectMenuIdByRoleId(params);
    }

    /**
     *设置角色对应菜单
     * @param params
     * @return
     */
    @RequestMapping(value = "/setRoleMenu")
    public MsgBean setRoleMenu(@RequestParam Map<String,Object> params){
        logger.info("SysMenuController =====================> setRoleMenu");
        return sysMenuService.setRoleMenu(params);
    }








}
