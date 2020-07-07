package com.njty.carpark.service;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.bean.TreeMsgBean;
import com.njty.carpark.entity.SysMenuEntity;
import com.njty.carpark.entity.TreeEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface SysMenuService {

    List<Map<String,Object>> getTopMenuTreeList(Map<String, Object> params);

    List<TreeEntity> getLeftMenuTreeList(Map<String, Object> params);

    List<TreeEntity> getAllMenuTreeList(Map<String, Object> params);

    TreeMsgBean getMenuList(Map<String, Object> params);

    MsgBean addMenu(@RequestParam Map<String, Object> params);

    MsgBean modMenu(Map<String, Object> params);

    MsgBean delMenuList(String[] id);

    MsgBean getSelectMenuIdByRoleId(Map<String, Object> params);

    MsgBean setRoleMenu(Map<String, Object> params);

    List<SysMenuEntity> getSysMenuByRoleId(String roleId);
}
