package com.ymPrac.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 启动类
 * Created by Yan Meng on 2016/9/21.
 */
//@Configuration  //配置控制
//@EnableAutoConfiguration    //启用自动配置
//@ComponentScan  //组件扫描
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@Controller
public class App {

    @Autowired
    private Producer producer;

    //启动Spring Boot项目的唯一入口
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/amq")
    @ResponseBody
    public String sendMsg (String msg) {
        producer.send(msg);

        return "success";
    }
}
