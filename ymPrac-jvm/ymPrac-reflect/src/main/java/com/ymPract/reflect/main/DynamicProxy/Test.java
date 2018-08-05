package com.ymPract.reflect.main.DynamicProxy;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        BusinessFooImpl bfoo = new BusinessFooImpl();
        BusinessFoo bf = (BusinessFoo)BusinessImplProxy.factory(bfoo);
        bf.foo();
        System.out.println();

        BusinessBarImpl bbar = new BusinessBarImpl();
        BusinessBar bb = (BusinessBar)BusinessImplProxy.factory(bbar);
        String message = bb.bar("Hello,World");
        System.out.println(message);
    }
}
