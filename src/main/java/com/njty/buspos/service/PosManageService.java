package com.njty.buspos.service;



import com.njty.buspos.bean.MsgBean;

import java.util.Map;

public interface PosManageService {


    MsgBean getPosList(Map<String, Object> params);

}
