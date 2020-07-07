package com.njty.carpark.mapper;


import com.njty.carpark.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    List<Map<String,Object>> getSysUserList(Map<String, Object> params);

    List<SysUserEntity> getSysUserList2(Map<String, Object> params);

    int addSysUser(Map<String, Object> params);

    int addSysUser2(SysUserEntity sysUser);

    int modSysUser(SysUserEntity sysUser);

    int delSysUserList(String[] id);

    SysUserEntity findUserByUsername(String username);

    int changePwd(Map<String, Object> params);


}
