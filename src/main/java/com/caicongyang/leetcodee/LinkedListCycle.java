package com.caicongyang.leetcodee;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *  判断单链表是否循环
 */
public class LinkedListCycle {


    // 头结点没人指向它
    // 其他节点只有一个人指向它


    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        Set<ListNode> set = new HashSet<>();
        while (null != pre) {
            Boolean flag = set.add(pre.next);
            if (!flag) {
                return true;
            }
            pre = pre.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(6);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(5);

        first.next = second;
        second.next = three;
        three.next = four;
        four.next = second;

        boolean b = hasCycle(first);
        System.out.println(b);


    }
}
