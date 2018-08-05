package com.ymPrac.concurrent.com.ifeve;

import java.util.ArrayList;
import java.util.List;

/**
 * 死锁
 * http://ifeve.com/deadlock/
 * Created by Yan Meng on 2017/7/25.
 */
public class Demo14 {

    public static void main(String[] args) throws InterruptedException {
        final TreeNode parent = new TreeNode();
        final TreeNode child = new TreeNode();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    parent.addChild(child);
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    child.setParent(parent);
                }
            }
        };

        thread1.setPriority(5);
        thread2.setPriority(1);

        thread1.start();
        thread2.start();
        Thread.sleep(100000000L);
    }

    public static class TreeNode {
        TreeNode parent = null;
        List<TreeNode> children = new ArrayList<>();

        public synchronized void addChild(TreeNode child) {
            if (!this.children.contains(child)) {
                this.children.add(child);
                child.setParentOnly(this);
                System.out.println("add child success");
            }
        }

        public synchronized void addChildOnly(TreeNode child) {
            if (!this.children.contains(child)) {
                this.children.add(child);
            }
        }

        public synchronized void setParent(TreeNode parent) {
            this.parent = parent;
            parent.addChildOnly(this);
            System.out.println("set parent success");
        }

        public synchronized void setParentOnly(TreeNode parent) {
            this.parent = parent;
        }
    }
}
