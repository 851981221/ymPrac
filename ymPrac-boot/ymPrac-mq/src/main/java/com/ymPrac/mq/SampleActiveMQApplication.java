package com.ymPrac.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * Created by Yan Meng on 2016/9/22.
 */
@Configuration
@EnableJms
public class SampleActiveMQApplication {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("TEST");
    }

}
