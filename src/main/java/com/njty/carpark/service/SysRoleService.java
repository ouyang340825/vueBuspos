package com.njty.carpark.service;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

public interface SysRoleService {


    MsgBean getSysRoleList(Map<String, Object> params);

    MsgBean addSysRole(Map<String, Object> params);

    MsgBean modSysRole(Map<String, Object> params);

    MsgBean delSysRoleList(String[] id);

    List<SysRoleEntity> getSysRoleByUser(String roleId);
}
