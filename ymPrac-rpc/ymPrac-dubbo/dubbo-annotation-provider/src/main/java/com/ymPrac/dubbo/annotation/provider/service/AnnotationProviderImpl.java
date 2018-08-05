package com.ymPrac.dubbo.annotation.provider.service;


import com.alibaba.dubbo.config.annotation.Service;

import com.ymPrac.dubbo.annotation.provider.api.service.AnnotationProvider;

/**
 * Created by Yan Meng on 2016/9/23.
 */
@Service(version = "1.0.0")
public class AnnotationProviderImpl implements AnnotationProvider {
    @Override
    public String sayAnnotation() {
        System.out.println("===============================================");
        return "hello annotation dubbo service";
    }
}
