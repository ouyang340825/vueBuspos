package com.njty.buspos.service;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.bean.TreeMsgBean;
import com.njty.buspos.entity.SysMenuEntity;
import com.njty.buspos.entity.TreeEntity;
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
