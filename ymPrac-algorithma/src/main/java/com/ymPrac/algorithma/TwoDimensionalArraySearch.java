package com.ymPrac.algorithma;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * a[0][0], a[1][0]
 * a[0][1], a[1][1]
 * a[0][2], a[1][2]
 *
 * @author Yan Meng
 * @date 2018/8/6.
 */
public class TwoDimensionalArraySearch {

    public static void main(String[] args) {
        int[][] array = {{}, {}, {}};
        solution(array, 10);
    }

    public static boolean solution(int[][] array, int target) {
        int colCount = array.length;
        int rowCount = array[0].length;

        for (int i=0, j=rowCount; i<colCount-1 && j>=0;) {
            int number = array[i][j];
            if (number == target) {
                return true;
            }

            if (number < target) {
                i++;
            }

            if (number > target) {
                j--;
            }
        }
        return false;
    }
}
