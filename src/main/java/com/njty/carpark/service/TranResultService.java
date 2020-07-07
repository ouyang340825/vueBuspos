package com.njty.carpark.service;


import com.njty.carpark.bean.MsgBean;

import java.util.Map;

public interface TranResultService {


    MsgBean getTranResultList(Map<String, Object> params);

}
