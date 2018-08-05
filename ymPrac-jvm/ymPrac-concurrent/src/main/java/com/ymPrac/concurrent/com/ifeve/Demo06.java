package com.ymPrac.concurrent.com.ifeve;

/**
 * 06 竞态条件与临界区
 * @url http://ifeve.com/race-conditions-and-critical-sections/
 * Created by Yan Meng on 2017/7/25.
 */
public class Demo06 {
    public static long count = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i=1; i<=10; i++) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }.start();
        }

        Thread.sleep(100);
        System.out.println(count);
    }
}
