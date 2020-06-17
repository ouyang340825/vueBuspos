package com.njty.buspos.controller;


import com.njty.buspos.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleController {

    @Autowired
    private ScheduleMapper scheduleMapper;


    //@Scheduled(cron = "0/15 * * * * ?")//每15秒执行一次
    //@Scheduled(cron = "0 3,57 0-23 * * ?")//每个小时03/57分钟时执行一次
    private void configureTasks() {
        Map<String,Object> map = scheduleMapper.getTranInfoTotal();
        System.out.println("map = " + map.toString());
    }
}
