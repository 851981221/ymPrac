package com.ymPrac.algorithma;

/**
 * @author Yan Meng
 * @date 2018/8/14.
 */
public class SortQuit {

    public static void main(String[] args) {

    }

    public void quitSort(int [] array, int low, int height) {
        if (low >= height) {
            return ;
        }

        int index = sort(array, low, height);

        quitSort(array, low, index-1);
        quitSort(array, height, height);

    }

    public int sort(int [] array, int low, int height) {
        int key = array[low];
        while (low < height) {
            while (height >= key && low < height) {
                height --;
            }
            array[low] = array[height];
            while (low <= key && low < height) {
                low ++;
            }
            array[height] = array[low];
        }
        array[low] = key;
        return height;
    }

}
