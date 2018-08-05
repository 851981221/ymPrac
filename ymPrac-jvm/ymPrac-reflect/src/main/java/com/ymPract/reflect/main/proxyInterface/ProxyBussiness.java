package com.ymPract.reflect.main.proxyInterface;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class ProxyBussiness implements Business {
    private RealBussiness realBussiness;

    public void doAction() {
        if (realBussiness == null) {
            realBussiness = new RealBussiness();
        }

        before();
        realBussiness.doAction();
        after();
    }

    public void before () {
        System.out.println("before --------------------------");
    }

    public void after () {
        System.out.println("after ----------------------------");
    }
}
