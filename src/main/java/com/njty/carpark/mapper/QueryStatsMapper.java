package com.njty.carpark.mapper;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface QueryStatsMapper {

    List<Map<String,Object>> getPosTranList(Map<String, Object> params);

    List<Map<String,Object>> getPosTranForEcharts(Map<String, Object> params);

    List<Map<String,Object>> getPosTranListForExport(Map<String, Object> params);

    List<Map<String,Object>> getCodeTranList(Map<String, Object> params);

    List<Map<String,Object>> getCodeTranForEcharts(Map<String, Object> params);

    List<Map<String,Object>> getCodeTranListForExport(Map<String, Object> params);

    List<Map<String,Object>> getStatsPosTranList(Map<String, Object> params);

    List<Map<String,Object>> getStatsPosTranListForExport(Map<String, Object> params);

    List<Map<String,Object>> getPosOnlineList(Map<String, Object> params);

    @Select("SELECT BLACKLIST_VER_BASE,RATE_VER_ONE,LAST_PRO_VER FROM TAB_SERVICE_STATUS")
    Map<String,Object> getServiceStatusInfo();

    List<Map<String,Object>> getPosInfoList(Map<String, Object> params);

    List<Map<String,Object>> getPosInfoListForExport(Map<String, Object> params);

    List<Map<String,Object>> getPosInfoNullList(Map<String, Object> params);

    List<Map<String,Object>> getPosInfoNullListForExport(Map<String, Object> params);

    List<Map<String,Object>> getPosregAllList(Map<String, Object> params);

    List<Map<String,Object>> getPosregList(Map<String, Object> params);

    List<Map<String,Object>> getPosregForChildTable(Map<String, Object> params);

    List<Map<String,Object>> getQuickPassDataList(Map<String, Object> params);

    List<Map<String,Object>> getQuickPassDataForEcharts(Map<String, Object> params);

    List<Map<String,Object>> getQuickPassDataListForExport(Map<String, Object> params);

    List<Map<String,Object>> getDevVersionCountList(Map<String, Object> params);

    List<Map<String,Object>> getOfflinePosInfoList(Map<String, Object> params);

    int delPosList(String[] id);

}
