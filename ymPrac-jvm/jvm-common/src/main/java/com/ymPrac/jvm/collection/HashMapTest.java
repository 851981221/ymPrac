package com.ymPrac.jvm.collection;

import java.util.HashMap;

/**
 * Created by Yan Meng on 2017/10/12.
 */
public class HashMapTest {

    public static void main(String[] args) {
        Object p = new Object();

        HashMap<String, String> map = new HashMap<>();
        map.put("", "");

        System.out.println(p.hashCode());

        System.out.println(5 & 31);

        int h = 5;
        int length = 16;
        int result = h & (length - 1);
        System.out.println(result);


        //========================= HashMap test ============================
        HashMap<String, String> sMap = new HashMap<>();
        for (int i=1; i<=100; i++) {
            sMap.put("k" + i, "vv" + i);
        }

    }
}
