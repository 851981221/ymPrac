package com.ymPrac.jvm.algorithm;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * Created by Yan Meng on 2017/10/18.
 */
public class Fibonacci {

    public int Fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 1, b = 1, r = 0;
        for (int i = 3; i <=  n; i ++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }
}
