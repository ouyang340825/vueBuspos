package com.njty.carpark.service;



import com.njty.carpark.bean.MsgBean;

import java.util.Map;

public interface UserService {


    MsgBean login(Map<String, Object> params);

}
