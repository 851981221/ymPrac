package com.ymPrac.jvm;

/**
 * Created by yanmeng on 2018/4/27.
 */
public class Test2 {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";

        int i = s1.charAt(2) - '0' + s2.charAt(2) - '0';
        int i2 = s1.charAt(2);

        System.out.println((int)(char) '0');

        System.out.println(i);
        System.out.println(i2);
    }
}
