package com.ymPract.reflect.main.DynamicProxy;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class BusinessBarImpl implements BusinessBar {
    public String bar(String message) {
        System.out.println("BusinessBarImpl.bar()");
        return message;
    }
}
