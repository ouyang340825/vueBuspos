package com.njty.carpark.service.impl;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.entity.SysUserEntity;
import com.njty.carpark.mapper.SysUserMapper;
import com.njty.carpark.service.SysUserService;
import com.njty.carpark.utils.Constants;
import com.njty.carpark.utils.MD5;
import com.njty.carpark.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public MsgBean getSysUserList(Map<String, Object> params) {
        List<Map<String,Object>> list = sysUserMapper.getSysUserList(params);
        return SystemUtils.toMsgBeanForSelect(list);

    }

    @Override
    public MsgBean getSysUserList2(Map<String, Object> params) {
        List<SysUserEntity> sysUserList = sysUserMapper.getSysUserList2(params);
        MsgBean msgBean = new MsgBean();
        if(sysUserList.size()>0){
            msgBean.setRows(sysUserList);
            int total= Integer.parseInt(sysUserList.get(0).getT());
            msgBean.setTotal(total);
        }else if(sysUserList.size()==0){
            msgBean.setTotal(0);
            msgBean.setMsg(Constants.GLOBAL_MSG_NORECORD);
        }
        return msgBean;
    }

    @Override
    @Transactional
    public MsgBean addSysUser(Map<String, Object> params) {
        String id = SystemUtils.getUUID();
        String password = "000000";
        String md5PW = MD5.MD5Encode(password);
        params.put("PASSWORD",md5PW);
        params.put("ID",id);
        String INSERT_TIME = SystemUtils.getCurrentSystemTime();
        params.put("INSERT_TIME",INSERT_TIME);
        int total  = sysUserMapper.addSysUser(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    public MsgBean addSysUser2(SysUserEntity sysUser) {
        String id = SystemUtils.getUUID();
        String password = "000000";
        String md5PW = MD5.MD5Encode(password);
        String INSERT_TIME = SystemUtils.getCurrentSystemTime();
        sysUser.setPassword(md5PW);
        sysUser.setId(id);
        sysUser.setInsertTime(INSERT_TIME);
        int total  = sysUserMapper.addSysUser2(sysUser);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean modSysUser(SysUserEntity sysUser) {
        int total  = sysUserMapper.modSysUser(sysUser);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean delSysUserList(String[] id) {
        int total  = sysUserMapper.delSysUserList(id);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    public SysUserEntity findUserByUsername(String username) {
        return sysUserMapper.findUserByUsername(username);
    }

    @Override
    public MsgBean changePwd(Map<String, Object> params) {
        int total  = sysUserMapper.changePwd(params);
        MsgBean msgBean= new MsgBean();
        if(total>0){
            msgBean.setSuccess(Constants.GLOBAL_MSG_BOOL_SUCCESS);
            msgBean.setMsg("密码修改成功，请重新登录");
        }
        return msgBean;
    }
}
