package com.ymPract.reflect.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class ReflectMain {

    public static void main(String[] args) {
        Map map = new HashMap();

        System.out.println(map.getClass().getName());
    }
}
