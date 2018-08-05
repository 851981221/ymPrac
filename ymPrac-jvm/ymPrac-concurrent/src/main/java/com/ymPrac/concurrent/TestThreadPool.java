package com.ymPrac.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Yan Meng on 2016/7/12.
 */
public class TestThreadPool {
    private static final int loopNum = 1 * 10000;

    private static final int sleepTime = 20000;

    private static final AtomicInteger connectionIds = new AtomicInteger(0);


    public static void main(String args[]) throws InterruptedException {
        // only two threads
        TestThreadPool TestThreadPool = new TestThreadPool();
        long bt = System.currentTimeMillis();
        TestThreadPool.m1();
        long et2 = System.currentTimeMillis();
        System.out.println("耗时:" + (et2 - bt) + "ms");
        Thread thread = new Thread();
        thread.sleep(sleepTime);
        if (connectionIds.get() == loopNum) {
            long et = System.currentTimeMillis();
            System.out.println("耗时:" + (et - bt - sleepTime) + "ms");
        }


    }

    public void m1() {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int index = 0; index < loopNum; index++) {
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        new Thread().sleep(1);
                        connectionIds.getAndIncrement();
                    } catch (Exception e) {
                    }
                }
            };
            exec.execute(run);
        }
        // must shutdown
        exec.shutdown();
    }

    public void m2() {
        for (int index = 0; index < loopNum; index++) {
            try {
                new Thread().sleep(1);
                connectionIds.getAndIncrement();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
