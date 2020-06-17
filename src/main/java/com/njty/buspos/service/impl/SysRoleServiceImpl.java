package com.njty.buspos.service.impl;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.entity.SysRoleEntity;
import com.njty.buspos.mapper.SysRoleMapper;
import com.njty.buspos.service.SysRoleService;
import com.njty.buspos.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public MsgBean getSysRoleList(Map<String, Object> params) {
        List<Map<String,Object>> list = sysRoleMapper.getSysRoleList(params);
        return SystemUtils.toMsgBeanForSelect(list);

    }

    @Override
    @Transactional
    public MsgBean addSysRole(Map<String, Object> params) {
        String id = SystemUtils.getUUID();
        params.put("ID",id);
        String INSERT_TIME = SystemUtils.getCurrentSystemTime();
        params.put("INSERT_TIME",INSERT_TIME);
        int total  = sysRoleMapper.addSysRole(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean modSysRole(Map<String, Object> params) {
        String UPDATE_TIME = SystemUtils.getCurrentSystemTime();
        params.put("UPDATE_TIME",UPDATE_TIME);
        int total  = sysRoleMapper.modSysRole(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean delSysRoleList(String[] id) {
        int total  = sysRoleMapper.delSysRoleList(id);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    public List<SysRoleEntity> getSysRoleByUser(String roleId) {
        return sysRoleMapper.getSysRoleByUser(roleId);
    }
}
