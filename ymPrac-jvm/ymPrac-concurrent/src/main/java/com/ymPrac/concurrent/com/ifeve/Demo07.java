package com.ymPrac.concurrent.com.ifeve;

/**
 * 线程安全与共享资源
 * @url http://ifeve.com/thread-safety/
 * Created by Yan Meng on 2017/7/25.
 */
public class Demo07 {

    public static void main(String[] args) throws InterruptedException {
        NotThreadSafe count = new NotThreadSafe();

        new Thread(new MyNotSafeThread(count)).start();
        new Thread(new MyNotSafeThread(count)).start();
        new Thread(new MyNotSafeThread(count)).start();
        new Thread(new MyNotSafeThread(count)).start();

        Thread.sleep(100);
        System.out.println(count.builder);
    }

    public static class MyNotSafeThread implements Runnable {
        private NotThreadSafe count = null;

        public MyNotSafeThread(NotThreadSafe count) {
            this.count = count;
        }

        @Override
        public void run() {
            count.add(" name ");
        }
    }

    public static class NotThreadSafe {
        StringBuilder builder = new StringBuilder();

        public void add(String text){
            this.builder.append(text);
        }
    }
}
