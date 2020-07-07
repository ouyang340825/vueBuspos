package com.njty.carpark.controller;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.service.TranResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/tranResult")
public class TranResultController {

    protected static final Logger logger = LoggerFactory.getLogger(TranResultController.class);

    @Autowired
    private TranResultService tranResultService;


    /**
     *设备管理---查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getTranResultList")
    public MsgBean getTranResultList(@RequestParam Map<String,Object> params){
        logger.info("TranResultController =====================> getTranResultList");
        return tranResultService.getTranResultList(params);
    }
    


}
