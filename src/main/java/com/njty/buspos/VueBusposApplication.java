package com.njty.buspos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.njty.buspos.mapper")
@SpringBootApplication
public class VueBusposApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueBusposApplication.class, args);
    }

}
