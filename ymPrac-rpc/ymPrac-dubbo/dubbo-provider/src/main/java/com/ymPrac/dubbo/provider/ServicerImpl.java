package com.ymPrac.dubbo.provider;

import org.springframework.stereotype.Service;

/**
 * Created by Yan Meng on 2016/9/23.
 */
@Service("testService")
public class ServicerImpl implements Servicer {
    @Override
    public String sayHello() {
        return "hello dubbo test servicer!!!";
    }
}
