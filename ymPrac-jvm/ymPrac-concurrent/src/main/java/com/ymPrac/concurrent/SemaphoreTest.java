package com.ymPrac.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore test
 * Created by Yan Meng on 2017/10/25.
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3, true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();    //lock
                    // do sth.
                    System.out.println("current Thread:--" + Thread.currentThread().getName());
                    Thread.sleep(1000);

                    semaphore.release();    //release
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 1; i<=20; i++) {
            Thread thread = new Thread(runnable, "t-" + i);
            thread.start();
        }

    }
}
