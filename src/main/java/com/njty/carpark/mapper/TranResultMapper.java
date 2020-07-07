package com.njty.carpark.mapper;


import java.util.List;
import java.util.Map;

public interface TranResultMapper {

    int getTranResultListTotal(Map<String, Object> params);

    List<Map<String,Object>> getTranResultList(Map<String, Object> params);

}
