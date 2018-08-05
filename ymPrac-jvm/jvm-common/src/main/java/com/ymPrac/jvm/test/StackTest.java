package com.ymPrac.jvm.test;

/**
 * Created by Yan Meng on 2016/10/23.
 */
public class StackTest {

    public static void main(String[] args) throws InterruptedException {
        runStatic(1, 100L, new Object());
    }

    private static int runStatic(int i, long l, Object o) throws InterruptedException {
//        Thread.sleep(1000L);
        return runStatic(i, l, o);
    }
}
