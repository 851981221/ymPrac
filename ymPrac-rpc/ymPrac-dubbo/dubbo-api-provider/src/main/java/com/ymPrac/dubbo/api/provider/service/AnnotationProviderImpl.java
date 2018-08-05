package com.ymPrac.dubbo.api.provider.service;

import org.springframework.stereotype.Service;

/**
 * Created by Yan Meng on 2016/9/23.
 */
@Service(value = "annotationProvider")
public class AnnotationProviderImpl implements AnnotationProvider {
    @Override
    public String sayAnnotation() {
        System.out.println("===============================================");
        return "hello annotation dubbo service";
    }
}
