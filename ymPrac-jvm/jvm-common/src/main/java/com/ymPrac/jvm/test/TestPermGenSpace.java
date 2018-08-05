package com.ymPrac.jvm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 持久代 oom
 * Created by Yan Meng on 2017/1/16.
 */
public class TestPermGenSpace {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            List<String> list = new ArrayList<String>();
            while (true) {
                list.add(UUID.randomUUID().toString().intern());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testByteArray () {
        byte[] a = new byte[10];

        byte[][] arrays = new byte[10][];
        arrays[0] = a;

        test(arrays);
    }

    public void test (byte[]... args) {

    }


}
