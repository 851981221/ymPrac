package com.ymPrac.jvm.algorithm;

import java.util.Scanner;

/**
 * 给定一个字符串，求第一个不重复的字符    abbcad -> c
 * Created by Yan Meng on 2017/10/13.
 */
public class StringNotRepeatChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tag = scanner.nextLine();

        // 字符重复次数统计（字母都是0--255之间的 ASCII）
        int[] flag = new int[256];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = 0;
        }

        for (int i = 0; i < tag.length(); i++) {
            flag[tag.charAt(i)]++;
        }

        for (int i = 0; i < tag.length(); i++) {
            if (flag[tag.charAt(i)] == 1) {
                System.out.println(String.valueOf(tag.charAt(i)));
                break;
            }
        }
    }

    /**
     * 当字符串是流水字符串的时候，也就是字符串只能访问一次的时候，我们的标数组就应该保存字符串的小标了。
     */
    public void test2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tag = scanner.nextLine();

        int[] flag = new int[256];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;
        }

        for (int i = 0; i < tag.length(); i++) {
            int index = tag.charAt(i);
            if (flag[index] >= 0) {
                flag[index] = -2;
            } else if (flag[index] == -1) {
                flag[index] = i;
            }
        }

        int min = 256;
        for (int aFlag : flag) {
            if (aFlag < 0) {
                continue;
            }
            if (min > aFlag) {
                min = aFlag;
            }
        }
        System.out.println(tag.charAt(min));
    }
}
