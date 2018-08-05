package com.ymPrac.jvm.test;

/**
 * Created by Yan Meng on 2017/8/10.
 */
//@FunctionalInterface
public interface LamInterface {

    public abstract void test1();

    default String test2() {
        return "";
    }

    static String test3(String a) {
        return "";
    }
}
