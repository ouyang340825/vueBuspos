package com.njty.carpark.controller;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     *登录
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public MsgBean login(@RequestBody Map<String,Object> param){
        return userService.login(param);
    }
}