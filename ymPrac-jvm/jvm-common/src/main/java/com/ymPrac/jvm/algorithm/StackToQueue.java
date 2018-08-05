package com.ymPrac.jvm.algorithm;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Created by Yan Meng on 2017/8/31.
 */
public class StackToQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() == 0) {
            while (stack1.size() != 0) {
                Integer i = stack1.pop();
                stack2.push(i);
            }
        }
        return stack2.pop();
    }
}
