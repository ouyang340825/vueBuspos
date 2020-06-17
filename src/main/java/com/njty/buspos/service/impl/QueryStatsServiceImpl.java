package com.njty.buspos.service.impl;


import com.njty.buspos.bean.MsgBean;
import com.njty.buspos.mapper.QueryStatsMapper;
import com.njty.buspos.service.QueryStatsService;
import com.njty.buspos.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class QueryStatsServiceImpl implements QueryStatsService {

    @Autowired
    private QueryStatsMapper queryStatsMapper;

    @Override
    public MsgBean getPosTranList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosTranList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getPosTranForEcharts(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosTranForEcharts(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getPosTranListForExport(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosTranListForExport(params);
        return SystemUtils.toMsgBeanForExportData(list);
    }

    @Override
    public MsgBean getCodeTranList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getCodeTranList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getCodeTranForEcharts(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getCodeTranForEcharts(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getCodeTranListForExport(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getCodeTranListForExport(params);
        return SystemUtils.toMsgBeanForExportData(list);
    }


    @Override
    public MsgBean getStatsPosTranList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getStatsPosTranList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getStatsPosTranListForExport(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getStatsPosTranListForExport(params);
        return SystemUtils.toMsgBeanForExportData(list);
    }

    @Override
    public MsgBean getPosOnlineList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosOnlineList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }


    @Override
    public MsgBean getPosInfoList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosInfoList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }


    @Override
    public MsgBean getPosInfoNullList(Map<String, Object> params) {
        Map<String,Object> statusInfo = queryStatsMapper.getServiceStatusInfo();
        params.put("RATE_VER_ONE",statusInfo.get("RATE_VER_ONE"));
        params.put("BLACKLIST_VER_BASE",statusInfo.get("BLACKLIST_VER_BASE"));
        params.put("LAST_PRO_VER",statusInfo.get("LAST_PRO_VER"));
        List<Map<String,Object>> list = queryStatsMapper.getPosInfoNullList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getPosregAllList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosregAllList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getPosregList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getPosregList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getPosregForChildTable(Map<String, Object> params) {
        Map<String,Object> statusInfo = queryStatsMapper.getServiceStatusInfo();
        params.put("RATE_VER_ONE",statusInfo.get("RATE_VER_ONE"));
        params.put("BLACKLIST_VER_BASE",statusInfo.get("BLACKLIST_VER_BASE"));
        params.put("LAST_PRO_VER",statusInfo.get("LAST_PRO_VER"));
        List<Map<String,Object>> list = queryStatsMapper.getPosregForChildTable(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getQuickPassDataList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getQuickPassDataList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getQuickPassDataForEcharts(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getQuickPassDataForEcharts(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean getDevVersionCountList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getDevVersionCountList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }



    @Override
    public MsgBean getOfflinePosInfoList(Map<String, Object> params) {
        List<Map<String,Object>> list = queryStatsMapper.getOfflinePosInfoList(params);
        return SystemUtils.toMsgBeanForSelect(list);
    }

    @Override
    public MsgBean delPosList(String[] id) {
        int total  = queryStatsMapper.delPosList(id);
        return SystemUtils.toMsgBeanForAddMOdDel(total);
    }

}
