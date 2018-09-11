package com.ymPrac.algorithma;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author Yan Meng
 * @date 2018/9/11.
 */
public class ArrayEvenMove {

    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4};
        move(array);
        System.out.println(Arrays.toString(array));
    }

    public static void move(int [] array) {
        if (array == null || array.length ==0) {
            return;
        }
        int i = 0, j;
        while (i < array.length) {
            while (i<array.length && (array[i]%2 == 1)) {
                i ++;
            }
            j = i + 1;
            while (j<array.length && (array[j]%2 == 0)) {
                j ++;
            }

            if (j < array.length) {
                int tmp = array[j];
                for (int j2 = j-1; j2>=i; j2--) {
                    array[j2+1] = array[j2];
                }
                array[i++] = tmp;
            } else {
                break;
            }
        }

    }
}
