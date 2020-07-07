package com.njty.carpark.mapper;


import java.util.List;
import java.util.Map;

public interface DevMapper {

    int getDevListTotal(Map<String, Object> params);

    List<Map<String,Object>> getDevList(Map<String, Object> params);

    int getDevStatusListTotal(Map<String, Object> params);

    List<Map<String, Object>> getDevStatusList(Map<String, Object> params);

    int addDev(Map<String, Object> params);

    int modDev(Map<String, Object> params);

    int delDevList(String[] id);


}
