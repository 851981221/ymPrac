package com.ymPrac.concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁（Spin lock）
 * Created by Yan Meng on 2017/9/15.
 */
public class SpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();

        // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!owner.compareAndSet(null, currentThread)) { }
        System.out.println("lock: " + currentThread.getName());
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        // 只有锁的拥有者才能释放锁
        owner.compareAndSet(currentThread, null);
        System.out.println("unlock: " + currentThread.getName());
    }


    //==================== test ======================
    public static void main(String[] args) throws InterruptedException {
        final SpinLock lock = new SpinLock();
        lock.lock();

        new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        lock.unlock();
    }
}
