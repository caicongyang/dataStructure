package com.caicongyang.leetcodee;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseNodesInKGroup {

    // todo 下次
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //虚拟节点的长度
        Integer len = 0;
        ListNode curNode = head;
        while (null != curNode) {
            len++;
            curNode = curNode.next;
        }
        //引入一个虚拟节点
        ListNode h = new ListNode(0);





        return null;
    }

}
