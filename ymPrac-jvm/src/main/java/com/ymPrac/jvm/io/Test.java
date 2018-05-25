package com.ymPrac.jvm.io;

import java.util.Calendar;

/**
 * @author Yan Meng
 * @date 2018/5/24
 */
public class Test {

    public static void main(String[] args) {
        String result = "[2018-05-22 00:00:01] [INFO ] [DisplayAgentHandler][trafficDistribute][124][nioEventLoopGroup-4-101] [trafficDistribute result] - [cityId:320100][houseCode: 103101804653][total: 2][deyou count: 0][lianjia count: 2]";
        int index = result.indexOf("houseCode: ");
        String substring = result.substring(index + 11, index + 23);
        System.out.println(substring);

        int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        System.out.println(day);
    }
}
