package com.ymPrac.concurrent.com.ifeve;

/**
 * 嵌套管程锁死
 * @url http://ifeve.com/nested-monitor-lockout/
 *
 * 简而言之，在lock方法中等待的线程需要其它线程成功调用unlock方法来退出lock方法，但是，
 * 在lock()方法离开外层同步块之前，没有线程能成功执行unlock()。
 * 结果就是，任何调用lock方法或unlock方法的线程都会一直阻塞。这就是嵌套管程锁死。
 * Created by Yan Meng on 2017/7/25.
 */
public class Demo17 {

    public static class Lock{
        protected MonitorObject monitorObject = new MonitorObject();
        protected boolean isLocked = false;

        public void lock() throws InterruptedException{
            synchronized(this){
                while(isLocked){
                    synchronized(this.monitorObject){
                        this.monitorObject.wait();
                    }
                }
                isLocked = true;
            }
        }

        public void unlock(){
            synchronized(this){
                this.isLocked = false;
                synchronized(this.monitorObject){
                    this.monitorObject.notify();
                }
            }
        }
    }

    public static class MonitorObject {

    }
}
