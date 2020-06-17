package com.njty.buspos.mapper;


import com.njty.buspos.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {

    List<Map<String,Object>> getSysRoleList(Map<String, Object> params);

    int addSysRole(Map<String, Object> params);

    int modSysRole(Map<String, Object> params);

    int delSysRoleList(String[] id);

    List<SysRoleEntity> getSysRoleByUser(String roleId);
}
