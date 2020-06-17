package com.njty.buspos.controller;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.service.UserService;
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