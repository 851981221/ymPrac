package com.ymPrac.concurrent.com.ifeve;

/**
 * 如何创建并运行java线程
 * @url http://ifeve.com/java-concurrency-thread-directory/
 *
 * 可能出现 *** java.lang.instrument ASSERTION FAILED ***: "error == JVMTI_ERROR_NONE" at ../../../src/share/in   是jdk bug  https://bugs.openjdk.java.net/browse/JDK-7142035
 * Created by Yan Meng on 2017/7/25.
 */
public class Demo05 {

    public static void main(String[] args) {
        // 1, 创建无内容的线程
        Thread thread = new Thread();
        thread.start();

        // MyThread
        new MyThread().start();

        // 如果主线程立即退出
//        System.exit(1);

        // runnable
        new Thread(new MyRunnable()).start();

        System.out.println(Thread.currentThread().getName());

        for (int i=1; i<=10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread:" + Thread.currentThread().getName() + "running!");
                }
            }).start();
        }
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "my thread demo running-=------");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "my runnable runing ------------------------");
        }
    }
}
