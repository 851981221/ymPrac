package com.ymPract.reflect.main.proxy;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class ProxyObj extends Abstract {

    private RealObj realObj = new RealObj();

    public void abstractMethod() {
        System.out.println("before ----------------");

        realObj.abstractMethod();

        System.out.println("after ----------------");
    }
}
