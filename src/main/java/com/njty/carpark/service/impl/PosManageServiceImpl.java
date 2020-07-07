package com.njty.carpark.service.impl;



import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.mapper.PosManageMapper;
import com.njty.carpark.service.PosManageService;
import com.njty.carpark.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;


@Service
public class PosManageServiceImpl implements PosManageService {

    @Autowired
    private PosManageMapper posManageMapper;

    @Override
    public MsgBean getPosList(Map<String, Object> params) {
        List<Map<String,Object>> list = posManageMapper.getPosList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

}
