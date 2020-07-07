package com.njty.carpark;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.njty.carpark.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class VueBusposApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VueBusposApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(VueBusposApplication.class, args);
    }

}
