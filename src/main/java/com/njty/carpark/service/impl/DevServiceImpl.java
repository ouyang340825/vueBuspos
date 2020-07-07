package com.njty.carpark.service.impl;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.mapper.DevMapper;
import com.njty.carpark.service.DevService;
import com.njty.carpark.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class DevServiceImpl implements DevService {

    @Autowired
    private DevMapper devMapper;

    @Override
    public MsgBean getDevList(Map<String, Object> params) {
        MsgBean msgBean = new MsgBean();
        int total = devMapper.getDevListTotal(params);
        msgBean.setTotal(total);
        if(total>0){
            List<Map<String,Object>> list = devMapper.getDevList(params);
            msgBean.setRows(list);
        }
        return msgBean;
    }

    @Override
    public MsgBean getDevStatusList(Map<String, Object> params) {
        MsgBean msgBean = new MsgBean();
        int total = devMapper.getDevStatusListTotal(params);
        msgBean.setTotal(total);
        if(total>0){
            List<Map<String,Object>> list = devMapper.getDevStatusList(params);
            msgBean.setRows(list);
        }
        return msgBean;
    }

    @Override
    @Transactional
    public MsgBean addDev(Map<String, Object> params) {
        int total  = devMapper.addDev(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean modDev(Map<String, Object> params) {
        int total  = devMapper.modDev(params);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

    @Override
    @Transactional
    public MsgBean delDevList(String[] id) {
        int total  = devMapper.delDevList(id);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }
}
