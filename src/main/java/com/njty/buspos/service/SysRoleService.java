package com.njty.buspos.service;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

public interface SysRoleService {


    MsgBean getSysRoleList(Map<String, Object> params);

    MsgBean addSysRole(Map<String, Object> params);

    MsgBean modSysRole(Map<String, Object> params);

    MsgBean delSysRoleList(String[] id);

    List<SysRoleEntity> getSysRoleByUser(String roleId);
}
