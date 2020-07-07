package com.njty.carpark.mapper;



import org.apache.ibatis.annotations.Select;


import java.util.Map;

public interface ScheduleMapper {



    @Select("select 1 from dual")
    Map<String,Object> getTranInfoTotal();

    @Select("SELECT A1.ID, A1.USERNAME, A1.PASSWD AS USERPWD, A1.USER_STAT AS USERSTAT, A2.ROLE_ID, A2.ROLE_NAME FROM T_USERS A1 " +
            " INNER JOIN T_BASE_ROLES A2 ON A1.ROLE_ID=A2.ROLE_ID " +
            "where A1.USERNAME = #{user} ")
    Map<String, Object> getUserInfo(Map<String,Object> param);
}
