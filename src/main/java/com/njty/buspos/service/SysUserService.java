package com.njty.buspos.service;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.entity.SysUserEntity;

import java.util.Map;

public interface SysUserService {


    MsgBean getSysUserList(Map<String, Object> params);

    MsgBean getSysUserList2(Map<String, Object> params);

    MsgBean addSysUser(Map<String, Object> params);

    MsgBean addSysUser2(SysUserEntity sysUser);

    MsgBean modSysUser(SysUserEntity sysUser);

    MsgBean delSysUserList(String[] id);

    SysUserEntity findUserByUsername(String username);

    MsgBean changePwd(Map<String, Object> params);

}
