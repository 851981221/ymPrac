package com.ymPrac.concurrent.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Yan Meng on 2016/7/12.
 */
class Producer implements Runnable {
    private BlockingQueue queue = null;

    Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(10000);
            queue.put("2");
            Thread.sleep(10000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
