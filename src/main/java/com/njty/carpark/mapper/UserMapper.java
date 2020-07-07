package com.njty.carpark.mapper;


import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserMapper {


    @Select("select * from SYS_USER t where t.username = #{username}")
    Map<String,Object> login(Map<String, Object> params);
}
