package com.ymPrac.web;

/**
 * Created by Yan Meng on 2017/12/15.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println(System.currentTimeMillis());
            sayHi();
            Thread.sleep(100);
        }
    }

    private static void sayHi() {
        System.out.println("hi---------------------------");
    }
}
