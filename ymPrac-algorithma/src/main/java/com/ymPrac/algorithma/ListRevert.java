package com.ymPrac.algorithma;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author Yan Meng
 * @date 2018/8/6.
 */
public class ListRevert {

    private static ArrayList<Integer> result = Lists.newArrayList();

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
