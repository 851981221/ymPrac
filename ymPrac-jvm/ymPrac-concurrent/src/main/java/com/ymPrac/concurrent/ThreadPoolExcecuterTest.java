package com.ymPrac.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Yan Meng on 2016/9/14.
 */
public class ThreadPoolExcecuterTest {
    private static final ExecutorService pool = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future> futures = new ArrayList<>();

        for (int i=1; i<=10000; i++) {
            final int finalI = i;
            Callable call = new Callable() {
                @Override
                public String call() throws Exception {
                    for (int j=1; j<=1000; j++) {
                        System.out.println(finalI + "======>" + j);
                    }
                    return finalI + "=======>";
                }
            };

            Future future = pool.submit(call);
            futures.add(future);
        }

        for (Future futureItem : futures) {
            Object o = futureItem.get();
        }

            pool.shutdown();
//        System.out.println("end=-========-=-=-==-=");
    }
}
