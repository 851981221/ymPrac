package com.ymPrac.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ArrayListConcurrentTest {

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        System.out.println(testArrayListAdd());
        System.out.println(testArrayListAddParallel());
        System.out.println(testArrayListAddParallelPool());
        System.out.println(testArrayListAddParallelPoolSafe());

        System.out.println(testArrayListAddParallelCoWList());
        System.out.println(testArrayListAddParallelConcurrentHashMap());
    }

    public static int testArrayListAdd() {
        long start = System.currentTimeMillis();

        List<String> result = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            result.add(String.valueOf(i));
        });
        System.out.println("testArrayListAdd cost: " + (System.currentTimeMillis()-start));
        return result.size();
    }

    public static int testArrayListAddParallel() {
        long start = System.currentTimeMillis();

        List<String> result = new ArrayList<>();
        IntStream.range(0, 1000).parallel().forEach(i -> {
            result.add(String.valueOf(i));
        });
        System.out.println("testArrayListAddParallel cost: " + (System.currentTimeMillis()-start));
        return result.size();
    }

    /**
     * 结果 不一定是 100  还有可能异常
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static int testArrayListAddParallelPool() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        List<Future> futures = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            Future<Boolean> future = EXECUTOR.submit(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return result.add(String.valueOf(i));
            });
            futures.add(future);
        });

        for (Future future : futures) {
            Object o = future.get();
        }
        System.out.println("testArrayListAddParallelPool cost: " + (System.currentTimeMillis()-start));
        return result.size();
    }

    public static int testArrayListAddParallelPoolSafe() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        List<Future> futures = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            Future<String> future = EXECUTOR.submit(() -> String.valueOf(i));
            futures.add(future);
        });

        for (Future future : futures) {
            String o = (String) future.get();
            result.add(o);
        }
        System.out.println("testArrayListAddParallelPoolSafe cost: " + (System.currentTimeMillis()-start));
        return result.size();
    }

    public static int testArrayListAddParallelConcurrentHashMap() {
        long start = System.currentTimeMillis();
        Map<String, Integer> result = new ConcurrentHashMap<>();
        IntStream.range(0, 1000).parallel().forEach(i -> {
            result.put(String.valueOf(i), 1);
        });
        System.out.println("testArrayListAddParallelConcurrentHashMap cost: " + (System.currentTimeMillis()-start));
        return result.size();
    }


    public static int testArrayListAddParallelCoWList() {
        long start = System.currentTimeMillis();
        List<String> result = new CopyOnWriteArrayList<>();
        IntStream.range(0, 1000).parallel().forEach(i -> {
            result.add(String.valueOf(i));
        });
        System.out.println("testArrayListAddParallelCoWList cost: " + (System.currentTimeMillis()-start));
        return result.size();
    }

}
