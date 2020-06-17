package com.njty.buspos.service.impl;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.bean.TreeMsgBean;
import com.njty.buspos.entity.SysMenuEntity;
import com.njty.buspos.entity.TreeEntity;
import com.njty.buspos.mapper.SysMenuMapper;
import com.njty.buspos.service.SysMenuService;
import com.njty.buspos.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Map<String, Object>> getTopMenuTreeList(Map<String, Object> params) {
        return sysMenuMapper.getTopMenuTreeList(params);
    }

    @Override
    public List<TreeEntity> getLeftMenuTreeList(Map<String, Object> params) {
        List<TreeEntity> list = sysMenuMapper.getLeftMenuTreeList(params);
        List<TreeEntity> listTree=ListToTree(list,params.get("name").toString());
        return listTree;
    }

    @Override
    public List<TreeEntity> getAllMenuTreeList(Map<String, Object> params) {
        List<TreeEntity> list = sysMenuMapper.getAllMenuTreeList(params);
        TreeEntity menuTree = new TreeEntity();
        menuTree.setId("0");
        menuTree.setPid("-1");
        menuTree.setTitle("所有菜单");
        menuTree.setSpread("false");
        list.add(menuTree);
        List<TreeEntity> listTree=ListToTree(list,params.get("name").toString());
        return listTree;
    }


    public List<TreeEntity> ListToTree(List<TreeEntity> list, String pid) {
        List<TreeEntity> arrayList = new ArrayList<TreeEntity>();
        for (int i = 0; i < list.size(); i++) {
            TreeEntity TreeEntity = list.get(i);
            if(TreeEntity.getPid()!=null){
                if (TreeEntity.getPid().equals(pid)) {
                    List<TreeEntity> listOrs = ListToTree(list, TreeEntity.getId());
                    if (listOrs.size() > 0) {
                        if (null != TreeEntity.getChildren() && TreeEntity.getChildren().size() > 0) {
                            List<TreeEntity> chilOrder = TreeEntity.getChildren();
                            for (int j = 0; j < listOrs.size(); j++) {
                                chilOrder.add(listOrs.get(j));
                            }
                            TreeEntity.setChildren(chilOrder);
                        }else{
                            TreeEntity.setChildren(listOrs);
                        }
                        arrayList.add(TreeEntity);
                    } else {
                        arrayList.add(TreeEntity);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override
    public TreeMsgBean getMenuList(Map<String, Object> params) {
        List<Map<String,Object>> list = sysMenuMapper.getMenuList(params);
        return SystemUtils.toMsgBeanForSelectTree(list);
    }

    @Override
    @Transactional
    public MsgBean addMenu(Map<String,Object> params) {
        String id = SystemUtils.getUUID();
        params.put("ID",id);
        int total  = sysMenuMapper.addMenu(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean modMenu(Map<String, Object> params) {
        int total  = sysMenuMapper.modMenu(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean delMenuList(String[] id) {
        int total  = sysMenuMapper.delMenuList(id);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    public MsgBean getSelectMenuIdByRoleId(Map<String, Object> params) {
        List<Map<String,Object>> list = sysMenuMapper.getSelectMenuIdByRoleId(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean setRoleMenu(Map<String, Object> params) {
        String ROLEID = params.get("ROLEID").toString();
        String selectData = params.get("selectData").toString();
        String[] selectId = selectData.split(",");
        String[] ID = new String[1];
        ID[0] = ROLEID ;
        int total = 0;
        sysMenuMapper.delRoleMenu(ID);
        for (int i = 0; i < selectId.length; i++){
            Map map = new HashMap();
            map.put("SYS_ROLE_ID",ROLEID);
            map.put("SYS_MENU_ID",selectId[i]);
            total  = total + sysMenuMapper.setRoleMenu(map);
        }
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    public List<SysMenuEntity> getSysMenuByRoleId(String roleId) {
        return sysMenuMapper.getSysMenuByRoleId(roleId);
    }
}
