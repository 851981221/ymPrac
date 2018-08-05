package com.ymPrac.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ticket Lock
 * Created by Yan Meng on 2017/9/15.
 */
public class TicketLock {

    private AtomicInteger serviceNum = new AtomicInteger(); // 服务号
    private AtomicInteger ticketNum = new AtomicInteger(); // 排队号

    public int lock() {
        // 首先原子性地获得一个排队号
        int myTicketNum = ticketNum.getAndIncrement();

        // 只要当前服务号不是自己的就不断轮询
        while (serviceNum.get() != myTicketNum) {
        }
        System.out.println("lock: " + myTicketNum);
        return myTicketNum;
    }

    public void unlock(int myTicket) {
        // 只有当前线程拥有者才能释放锁
        int next = myTicket + 1;
        serviceNum.compareAndSet(myTicket, next);
        System.out.println("unlock: " + serviceNum);
    }


    //=================== test ===============================
    public static void main(String[] args) throws InterruptedException {
        final TicketLock lock = new TicketLock();

        int ticket = lock.lock();

        new Thread(new Runnable() {
            public void run() {
                try {
                    int ticket = lock.lock();
                    Thread.sleep(1000);
                    lock.unlock(ticket);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
        lock.unlock(ticket);
    }
}
