package com.ymPrac.dubbo.annotation.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 * Created by Yan Meng on 2016/9/21.
 */
@Configuration  //配置控制
@EnableAutoConfiguration    //启用自动配置
@ComponentScan("com.ymPrac.dubbo.annotation.consumer")  //组件扫描
//@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App {

    //启动Spring Boot项目的唯一入口
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
