package com.dyq.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liuxin on 17/1/20.
 */
@SpringBootApplication
@MapperScan(value = "com.dyq.dao")
@ComponentScan(value = {"com.dyq.service","com.dyq.web.controller"})
public class webApplication {

    public static void main(String[] args) {
        SpringApplication.run(webApplication.class, args);
    }
}
