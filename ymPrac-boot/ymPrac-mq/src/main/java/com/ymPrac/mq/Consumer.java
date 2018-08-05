package com.ymPrac.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者 监听
 * Created by Yan Meng on 2016/9/22.
 */
@Component
public class Consumer {

    @JmsListener(destination = "TEST")
    public void receiveQueue(String text) {
        System.out.println("receive msg ---");
        System.out.println(text);
    }
}
