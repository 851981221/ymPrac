package com.ymPrac.jvm.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan Meng on 2017/8/25.
 */
public class ObjectLoop {


    public static void main(String[] args) {
        Map<String, Object> creating = new HashMap<>();

        new A(creating);

        System.out.println("-----------------------");
    }

    static class A {
        public A(Map<String, Object> creating) {
            new B(creating);
        }
    }

    static class B {
        public B(Map<String, Object> creating) {
            new C(creating);
        }
    }

    static class C {
        public C(Map<String, Object> creating) {
            new A(creating);
        }
    }
}
