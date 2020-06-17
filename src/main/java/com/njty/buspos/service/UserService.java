package com.njty.buspos.service;



import com.njty.buspos.bean.MsgBean;

import java.util.Map;

public interface UserService {


    MsgBean login(Map<String, Object> params);

}
