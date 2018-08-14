package com.ymPrac.algorithma;

/**
 * @author Yan Meng
 * @date 2018/8/8.
 */
public class BinaryNumberOfoneCount {

    public static void main(String[] args) {

    }

    public static int count(int count) {
        int result = 0;
        char[] chars = Integer.toBinaryString(count).toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                result ++;
            }
        }

        return result;
    }
}
