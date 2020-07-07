package com.njty.carpark.service;


import com.njty.carpark.bean.MsgBean;

import java.util.Map;

public interface QueryStatsService {

    MsgBean getPosTranList(Map<String, Object> params);

    MsgBean getPosTranForEcharts(Map<String, Object> params);

    MsgBean getPosTranListForExport(Map<String, Object> params);

    MsgBean getCodeTranList(Map<String, Object> params);

    MsgBean getCodeTranForEcharts(Map<String, Object> params);

    MsgBean getCodeTranListForExport(Map<String, Object> params);

    MsgBean getStatsPosTranList(Map<String, Object> params);

    MsgBean getStatsPosTranListForExport(Map<String, Object> params);

    MsgBean getPosOnlineList(Map<String, Object> params);

    MsgBean getPosInfoList(Map<String, Object> params);

    MsgBean getPosInfoNullList(Map<String, Object> params);

    MsgBean getPosregAllList(Map<String, Object> params);

    MsgBean getPosregList(Map<String, Object> params);

    MsgBean getPosregForChildTable(Map<String, Object> params);

    MsgBean getQuickPassDataList(Map<String, Object> params);

    MsgBean getQuickPassDataForEcharts(Map<String, Object> params);

    MsgBean getDevVersionCountList(Map<String, Object> params);

    MsgBean getOfflinePosInfoList(Map<String, Object> params);

    MsgBean delPosList(String[] id);

}
