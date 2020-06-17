package com.njty.buspos.controller;


import com.njty.buspos.mapper.ScheduleMapper;
import com.njty.buspos.socker.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private ScheduleMapper scheduleMapper;


    /**
     *车辆管理---查询
     * @param
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method= RequestMethod.GET)
    public Map<String,Object> getUserInfo(@RequestParam Map<String,Object> param){
        System.out.println("param = " + param);
        return scheduleMapper.getUserInfo(param);
    }

    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push")
    public void pushToWeb(String message) {
        try {
            WebSocketServer.sendInfo("大萨达啥多啥","20");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}