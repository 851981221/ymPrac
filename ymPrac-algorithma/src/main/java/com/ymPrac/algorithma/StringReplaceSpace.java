package com.ymPrac.algorithma;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author Yan Meng
 * @date 2018/8/6.
 */
public class StringReplaceSpace {

    public static void main(String[] args) {
        String string = "asdf asdf asdf";
        System.out.println(solution(string));
    }

    public static String solution(String string) {
        String result = "";
        for (int i=0; i<string.length(); i++){
            if (string.charAt(i) == ' ') {
                result += "%20";
            } else {
                result += string.charAt(i);
            }
        }
        return result;
    }
}
