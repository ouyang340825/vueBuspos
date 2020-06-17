package com.njty.buspos.mapper;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PosManageMapper {


    @Select("SELECT C1.* FROM (SELECT B1.*, ROWNUM RN FROM (" +
            "SELECT TP.LINE_NO AS LINENO, TP.COMPANY_NO,A1.*,count(*) over() as TOTAL  FROM TAB_POSINFO A1 " +
            "LEFT JOIN TAB_POSREG TP ON TP.POS_ID = A1.POS_ID ORDER BY TP.COMPANY_NO,TP.LINE_NO, A1.POS_ID) B1 " +
            "WHERE ROWNUM<=#{page} * #{limit} + #{limit}" +
            ")C1 " +
            "WHERE RN>#{page} * #{limit}")
    List<Map<String,Object>> getPosList(Map<String, Object> params);
}
