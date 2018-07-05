package com.ymPrac.hytrix.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@org.springframework.stereotype.Service
public class Service {

    @HystrixCommand(
            fallbackMethod = "fallback",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "200"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1")
            })
    public String getInfo() throws InterruptedException {
        Thread.sleep(1000);
        return "service success!";
    }

    public String fallback(Throwable e) {
        e.printStackTrace();
        return "service fail but mock success haha!";
    }
}
