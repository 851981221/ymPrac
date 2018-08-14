package com.ymPrac.algorithma;

/**
 * @author Yan Meng
 * @date 2018/8/8.
 */
public class FibonacciSequence {

    public static void main(String[] args) {

    }

    public static int solution(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int r = 0;
        int a = 1;
        int b = 1;
        for (int i=0; i<n; i++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }

    /**
     * 动态规划 更简单
     */
    public static int Dynamic(int n) {
        int f = 0;
        int g = 1;

        while (n-- >= 0) {
            g += f;
            f = g - f;
        }
        return f;
    }
}
