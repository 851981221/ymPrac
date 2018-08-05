package com.ymPrac.jvm.test;

import java.math.BigDecimal;

/**
 * Created by Yan Meng on 2017/2/27.
 */
public class BigdecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(2.34444);

        BigDecimal bigDecimal = a.setScale(1, BigDecimal.ROUND_CEILING);

        BigDecimal result = a.divide(BigDecimal.ONE).setScale(0, BigDecimal.ROUND_UP);
        System.out.println(result);

        System.out.println("====================================");

        BigDecimal aa = BigDecimal.valueOf(10).setScale(0);
        BigDecimal bb = BigDecimal.valueOf(10.01).setScale(2);

        BigDecimal subtract = aa.subtract(bb);

        System.out.println(subtract.compareTo(BigDecimal.ZERO));
    }
}
