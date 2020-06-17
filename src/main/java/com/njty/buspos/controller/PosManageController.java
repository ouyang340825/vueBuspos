package com.njty.buspos.controller;



import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.service.PosManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/system/posManage")
public class PosManageController {

    protected static final Logger logger = LoggerFactory.getLogger(PosManageController.class);

    @Autowired
    private PosManageService posManageService;


    /**
     *POS管理---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosList")
    public MsgBean getPosList(@RequestParam Map<String,Object> params){
        logger.info("PosManageController =====================> getPosList");
        return posManageService.getPosList(params);
    }




}
