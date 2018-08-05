package com.ymPrac.concurrent.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yan Meng on 2016/7/12.
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("=================== 1111111111111");
                }
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("=================== 2222222222222222");
                }
            }
        });
//        executorService.shutdown();
    }
}
