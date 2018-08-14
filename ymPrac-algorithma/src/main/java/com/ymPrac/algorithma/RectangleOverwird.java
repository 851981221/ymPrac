package com.ymPrac.algorithma;

/**
 * @author Yan Meng
 * @date 2018/8/8.
 */
public class RectangleOverwird {

    public static void main(String[] args) {

    }

    public static int solution(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n * 2 == 2) {
            return 1;
        }
        if (n * 2 == 4) {
            return 2;
        }
        return solution(n - 1) + solution(n - 2);
    }
}
