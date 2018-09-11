package com.ymPrac.algorithma;

import java.util.IllegalFormatException;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author Yan Meng
 * @date 2018/9/10.
 */
public class Power {

    public static void main(String[] args) {

    }

    public static double power(double base, int n) {
        double result = 1;
        double curr = base;

        int exponent = 0;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0) {
                throw new IllegalArgumentException("arg error");
            }
            exponent = -exponent;
        } else {
            return 1;
        }

        while (exponent != 0) {
            if ((exponent&1) == 1) {
                result = result * curr;
            }
            curr *= curr;
            exponent>>=1;
        }
        return n>=0 ? result : 1/result;
    }
}
