package com.njty.carpark.service.impl;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.mapper.TranResultMapper;
import com.njty.carpark.service.TranResultService;
import com.njty.carpark.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class TranResultServiceImpl implements TranResultService {

    @Autowired
    private TranResultMapper tranResultMapper;

    @Override
    public MsgBean getTranResultList(Map<String, Object> params) {
        MsgBean msgBean = new MsgBean();
        int total = tranResultMapper.getTranResultListTotal(params);
        msgBean.setTotal(total);
        if(total>0){
            List<Map<String,Object>> list = tranResultMapper.getTranResultList(params);
            msgBean.setRows(list);
        }
        return msgBean;
    }
}
