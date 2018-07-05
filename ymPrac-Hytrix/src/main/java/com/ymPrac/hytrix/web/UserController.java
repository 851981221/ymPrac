package com.ymPrac.hytrix.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping({ "/test" })
public class UserController {

    @Resource
    private Service service;

    @RequestMapping(value = "/user")
    @HystrixCommand(
            fallbackMethod = "fallback",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1")
            })
    public String getUser1() throws InterruptedException{
        Thread.sleep(1000);
        return service.getInfo();
    }

    public String fallback(Throwable e) {
        e.printStackTrace();
        return "controller fail suc";
    }
}
