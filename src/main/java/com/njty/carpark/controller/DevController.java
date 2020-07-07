package com.njty.carpark.controller;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.service.DevService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/dev")
public class DevController {

    protected static final Logger logger = LoggerFactory.getLogger(DevController.class);

    @Autowired
    private DevService devService;


    /**
     *设备管理---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getDevList")
    public MsgBean getDevList(@RequestParam Map<String,Object> params){
        logger.info("DevController =====================> getDevList");
        return devService.getDevList(params);
    }
    /**
     *设备状态查询---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getDevStatusList")
    public MsgBean getDevStatusList(@RequestParam Map<String,Object> params){
        logger.info("DevController =====================> getDevStatusList");
        return devService.getDevStatusList(params);
    }


    /**
     *设备管理---新增
     * @param params
     * @return
     */
    @RequestMapping(value = "/addDev")
    public MsgBean addDev(@RequestParam Map<String,Object> params){
        logger.info("DevController =====================> addDev");
        return devService.addDev(params);
    }


    /**
     *设备管理---修改
     * @param params
     * @return
     */
    @RequestMapping(value = "/modDev")
    public MsgBean modDev(@RequestParam Map<String,Object> params){
        logger.info("DevController =====================> modDev");
        return devService.modDev(params);
    }


    /**
     *设备管理---删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delDevList")
    public MsgBean delDevList(@RequestBody String[] id){
        logger.info("DevController =====================> delDevList");
        return devService.delDevList(id);
    }











}
