package com.njty.carpark.mapper;


import com.njty.carpark.entity.SysMenuEntity;
import com.njty.carpark.entity.TreeEntity;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper {

    List<TreeEntity> getLeftMenuTreeList(Map<String, Object> params);

    List<Map<String,Object>> getTopMenuTreeList(Map<String, Object> params);

    List<TreeEntity> getAllMenuTreeList(Map<String, Object> params);

    List<Map<String,Object>> getMenuList(Map<String, Object> params);

    int addMenu(Map<String, Object> params);

    int modMenu(Map<String, Object> params);

    int delMenuList(String[] id);

    List<Map<String,Object>> getSelectMenuIdByRoleId(Map<String, Object> params);

    int delRoleMenu(String[] idArr);

    int setRoleMenu(Map<String, Object> params);

    List<SysMenuEntity> getSysMenuByRoleId(String roleId);
}
