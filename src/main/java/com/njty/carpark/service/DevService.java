package com.njty.carpark.service;


import com.njty.carpark.bean.MsgBean;

import java.util.Map;

public interface DevService {


    MsgBean getDevList(Map<String, Object> params);

    MsgBean getDevStatusList(Map<String, Object> params);

    MsgBean addDev(Map<String, Object> params);

    MsgBean modDev(Map<String, Object> params);

    MsgBean delDevList(String[] id);


}
