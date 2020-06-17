package com.njty.buspos.controller;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/system/sysRole")
public class SysRoleController {

    protected static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;


    /**
     *系统角色管理---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getSysRoleList")
    public MsgBean getSysRoleList(@RequestParam Map<String,Object> params){
        logger.info("SysRoleController =====================> getSysRoleList");
        return sysRoleService.getSysRoleList(params);
    }


    /**
     *系统角色管理---新增
     * @param params
     * @return
     */
    @RequestMapping(value = "/addSysRole")
    public MsgBean addSysRole(@RequestParam Map<String,Object> params){
        logger.info("SysRoleController =====================> addSysRole");
        return sysRoleService.addSysRole(params);
    }


    /**
     *系统角色管理---修改
     * @param params
     * @return
     */
    @RequestMapping(value = "/modSysRole")
    public MsgBean modSysRole(@RequestParam Map<String,Object> params){
        logger.info("SysRoleController =====================> modSysRole");
        return sysRoleService.modSysRole(params);
    }


    /**
     *系统角色管理---删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delSysRoleList")
    public MsgBean delSysRoleList(@RequestBody String[] id){
        logger.info("SysRoleController =====================> delSysRoleList");
        return sysRoleService.delSysRoleList(id);
    }











}
