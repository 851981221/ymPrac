package com.ymPrac.jvm.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 约瑟夫环的java实现
 * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。从编号为k的人开始报数，
 * 数到m的那个人出列;他的下一个人又从1开始报数，数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
 * Created by Yan Meng on 2017/10/13.
 */
public class Josephus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入总人数：");
        int totalNum = scanner.nextInt();
        System.out.print("请输入报数的大小：");
        int cycleNum = scanner.nextInt();
        yuesefu(totalNum, cycleNum);
    }

    private static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }

    /**
     * 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
     *
     * 思路：
     1.把所有人先放入数组中，size为n+1
     2.当报到m的人，且dead不等于n-1时，此人退出游戏，这时候把数组中这个值置为0，报数从新开始
     3.如果这个人报数等于m，并且已经死了n-1个人，说明当前这个人就是最后的一个
     */
    public void test2() {
        int arr[] = new int[101];//报数从1开始所以数组大小为n+1
        int n = 100, m = 3;
        int i;
        int dead = 0;   //表示已经死了多少人
        int num = 0;    //num模拟报数
        for (i = 1; i <= n; i++) {
            //开始时每个人都可以报数，为了能得到最后一个人的编号，我们让初始值为i下标
            arr[i] = i;
        }

        for (i = 1; ; i++) {
            if (i > n) {
                //如果大于总人数，我们就从头开始
                i = i % n;
            }

            if (arr[i] > 0) {
                //如果当前这个人没有死，就报数
                num++;
            }

            if (m == num && dead != n - 1) {
                //如果当前这个人报的数等于m 并且没有已经死亡n-1个人
                num = 0;
                arr[i] = 0;
                dead++;
            } else if (m == num && dead == n - 1) {
                //如果这个人报数等于m，并且已经死了n-1个人，说明当前这个人就是最后的一个活着的了。
                System.out.print(arr[i] + "");
                break;
            }

        }

    }

}
