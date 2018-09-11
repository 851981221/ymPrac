package com.ymPrac.algorithma;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author Yan Meng
 * @date 2018/9/10.
 */
public class NumberOf1 {
    public static void main(String[] args) {

    }

    /**
     * 标准版本
     */
    public static int numberOf1(int n) {
        int result = 0;

        while (n != 0) {
            result++;
            n = n & (n-1);
        }
        return result;
    }

    /**
     * java 简化版本
     */
    public static int simpleMethod(int n) {
        int result = 0;
        char[] binaryArray = Integer.toBinaryString(n).toCharArray();
        for (char c : binaryArray) {
            if (c == '1') {
                result ++;
            }
        }
        return result;
    }
}
