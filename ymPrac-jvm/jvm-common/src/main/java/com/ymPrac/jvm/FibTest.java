package com.ymPrac.jvm;

/**
 * 递归与尾递归
 * Created by Yan Meng on 2018/1/9.
 */
public class FibTest {

    //普通递归
    public static long fib_1(int n) {
        if (n <= 1) {
            return 1;
        }
        return fib_1(n - 1) + fib_1(n - 2);
    }

    //尾递归
    public static long fib_2(int n) {
        return fib_iter(1, 1, n);
    }

    public static long fib_iter(long a, long b, int n) {
        if (n <= 0) {
            return a;
        }
        return fib_iter(b, a + b, n - 1);
    }

    //for循环
    public static long fib_3(int n) {
        if (n <= 1) {
            return 1;
        } else {
            long fib = 0;
            long a = 1;
            long b = 1;
            for (int i = 1; i < n; i++) {
                fib = a + b;
                a = b;
                b = fib;
            }
            return fib;
        }
    }


    //测试
    public static void main(String[] args) {
        int NUM = 40;
        long startTime1 = System.currentTimeMillis();
        long m = fib_2(NUM);
        long endTime1 = System.currentTimeMillis();
        System.out.println("fib_2:" + m);
        System.out.println("Time:" + (endTime1 - startTime1));

        long startTime2 = System.currentTimeMillis();
        long k = fib_3(NUM);
        long endTime2 = System.currentTimeMillis();
        System.out.println("fib_3:" + k);
        System.out.println("Time:" + (endTime2 - startTime2));

        long startTime = System.currentTimeMillis();
        long n = fib_1(NUM);
        long endTime = System.currentTimeMillis();
        System.out.println("fib_1:" + n);
        System.out.println("Time:" + (endTime - startTime));
    }
}
