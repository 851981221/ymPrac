package com.ymPrac.algorithma;

/**
 * @author Yan Meng
 * @date 2018/8/8.
 */
public class ForkJumpFloor {

    public static void main(String[] args) {

    }

    public static int jump(int n) {
        if (n <= 0) return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int i = 1;
        int j = 2;
        while (n-- >= 0) {
            j += i;
            i -= j;
        }
        return j;
    }
}
