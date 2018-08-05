package com.ymPrac.concurrent.blockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Yan Meng on 2016/7/12.
 */
public class BlockingQueueExample {
    public static void maian(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("aaaaaaaaaaa");
        list.add("bbbbbbbbbbb");

        for (String s :
                list) {
            s = "1111111111111111111";
        }

        for (String s :
                list) {
            System.out.println(s);
        }
    }
}
