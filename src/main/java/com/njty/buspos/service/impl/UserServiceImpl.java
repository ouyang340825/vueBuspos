package com.njty.buspos.service.impl;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.mapper.UserMapper;
import com.njty.buspos.service.UserService;
import com.njty.buspos.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public MsgBean login(Map<String, Object> params) {
        Map<String,Object> list = userMapper.login(params);
        MsgBean msgBean = new MsgBean();
        if(list==null){
            msgBean.setSuccess(false);
            msgBean.setMsg("用户名错误");
        }else{
            String psd = params.get("password").toString();
            String p = MD5.MD5Encode(psd);
            if(p.equals(list.get("PASSWORD"))){
                msgBean.setSuccess(true);
            }else{
                msgBean.setSuccess(false);
                msgBean.setMsg("密码错误");
            }
        }
        return msgBean;
    }

}
