package com.ymPrac.mq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;

/**
 * 测试
 * Created by Yan Meng on 2016/9/22.
 */
public class ActiveMQTest extends BaseTest {

//    @Rule
//    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private Producer producer;

    @Test
    public void sendSimpleMessage() throws InterruptedException, JMSException {
        this.producer.send("Test message");
        Thread.sleep(10000L);
//        assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
    }
}
