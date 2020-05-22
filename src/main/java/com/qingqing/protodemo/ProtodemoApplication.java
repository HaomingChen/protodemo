package com.qingqing.protodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qingqing.protodemo.mapper")
public class ProtodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtodemoApplication.class, args);
    }

}
