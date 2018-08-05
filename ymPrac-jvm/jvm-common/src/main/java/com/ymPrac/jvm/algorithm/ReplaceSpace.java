package com.ymPrac.jvm.algorithm;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by Yan Meng on 2017/8/31.
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int[] spaceAts = new int[chars.length];
        for (int i=0,j=0; i<chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ' ') {
                spaceAts[j] = i;
                j++;
            }
        }

        //space length
        int spaceLength = spaceAts.length;

        //move item
        for (int i=chars.length-1; i>=0; i--) {
            //if space move to end not null

        }
        return "";
    }
}
