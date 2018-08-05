package com.ymPract.reflect.main;

import com.ymPract.reflect.main.proxy.ProxyObj;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class ProxyTest {

    public void testProxy () {
        ProxyObj proxyObj = new ProxyObj();

        proxyObj.abstractMethod();
    }

}
