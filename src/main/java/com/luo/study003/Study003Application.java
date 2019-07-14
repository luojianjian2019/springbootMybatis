package com.luo.study003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan(value = "com.luo.study003.mapper")
@SpringBootApplication
public class Study003Application {

    public static void main(String[] args) {
        SpringApplication.run(Study003Application.class, args);
    }

}
