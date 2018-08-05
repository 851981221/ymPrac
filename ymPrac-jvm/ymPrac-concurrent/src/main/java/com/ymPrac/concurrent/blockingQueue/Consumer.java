package com.ymPrac.concurrent.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Yan Meng on 2016/7/12.
 */
class Consumer implements Runnable {
    private BlockingQueue queue = null;

    Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
