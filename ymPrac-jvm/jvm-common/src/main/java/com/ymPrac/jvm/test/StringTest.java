package com.ymPrac.jvm.test;

import java.util.Arrays;

/**
 * Created by Yan Meng on 2017/3/15.
 */
public class StringTest {

    public static void main(String[] args) {
        if (a() || b()) {
            System.out.println("==============================");
        }



        String s = "aaa";

        String[] idsArray = s.split(";");

        System.out.println(Arrays.toString(idsArray));

        String regEx = "[A-Z,a-z,0-9~！!@#￥$%^&*_+=\uFEFF|/<>：；，.。“‘(）【】{}-]*";
        String a = "-";
        boolean matches = a.matches(regEx);
        try {
            System.out.println(matches);
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println("finally");
        }
    }

    public static boolean a () {
        System.out.println("aaaaaaaaaaaa");
        return true;
    }

    public static boolean b () {
        System.out.println("bbbbbbbbbbbbbb");
        return false;
    }
}
