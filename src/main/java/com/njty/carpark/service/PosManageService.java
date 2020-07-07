package com.njty.carpark.service;



import com.njty.carpark.bean.MsgBean;

import java.util.Map;

public interface PosManageService {


    MsgBean getPosList(Map<String, Object> params);

}
