package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScans(
        @MapperScan("com.example.mapper")//扫描对应的mapper接口并关联其xml文件并注册为bean（重要）
)
public class SpringBootTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootTestApplication.class, args);
        //扫描SpringBootTestApplication 同包或子包下的类
    }

}
