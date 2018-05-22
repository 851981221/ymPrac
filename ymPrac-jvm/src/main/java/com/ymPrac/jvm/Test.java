package com.ymPrac.jvm;

import java.util.stream.Stream;

/**
 * Created by yanmeng on 2018/4/27.
 */
public class Test {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("base", "ball");
        stream.mapToInt(s -> s.length()).forEach(System.out::print);

    }

    /**
     * 实现一个时间复杂度为O(n)的算法，在存储一系列整数的数组中找出最大最小的两个。
     */
    private static void compareAndSelect(int[] intArray) {
        // init num
        int min = intArray[0];
        int max = intArray[0];

        for (int i : intArray) {
            int value = intArray[i];
            // select max num
            if (value > max) {
                max = value;
            }
            // select min num
            if (value < min) {
                min = value;
            }
        }
    }


    /**
     *两个非常大的数字（超过Long最大能表达的范围）的加法运算？不能使用Java现成的包
     * @param str1
     * @param str2
     * @return
     */
    private static String bigNumAdd(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        StringBuilder s1 = new StringBuilder(str1).reverse();
        StringBuilder s2 = new StringBuilder(str2).reverse();
        StringBuilder res = new StringBuilder();
        int s1Length = s1.length();
        int s2Length = s2.length();
        int len;
        if (s1Length < s2Length) {
            len = s2Length;
            int count = s2Length - s1Length;
            while (count-- > 0) {
                s1.append('0');
            }
        } else {
            len = s1Length;
            int count = s1Length - s2Length;
            while (count-- > 0) {
                s2.append('0');
            }
        }
        int overflow = 0;
        int num;
        for (int i = 0; i < len; i++) {
            num = s1.charAt(i) - '0' + s2.charAt(i) - '0' + overflow;
            if (num >= 10) {
                overflow = 1;
                num -= 10;
            } else {
                overflow = 0;
            }
            res.append(String.valueOf(num));
        }
        if (overflow == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

}

class Pass {
    public static void main(String[] args) {
        int x = 5;
        Pass p = new Pass();
        p.doStuff(x);
        System.out.print(" main x = " + x);
    }

    void doStuff(int x) {
        System.out.println(" doStuff x = " + x++);
    }
}

