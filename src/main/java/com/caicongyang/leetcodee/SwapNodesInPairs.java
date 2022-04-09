package com.caicongyang.leetcodee;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换、
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {


    /**
     * @param head
     * @return
     */

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(0); //引入一个虚拟节点
        h.next = head;
        ListNode posNode = h;
        ListNode tmp;

        while (posNode.next != null && posNode.next.next != null) {

            tmp = posNode.next;  // 1   3
            posNode.next = tmp.next;  //  2 4
            tmp.next = tmp.next.next; // 3  null

            posNode.next.next = tmp;  // 1  3
            posNode = tmp;  // 1   3

        }

        return h.next;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode three = new ListNode(3);
          ListNode four = new ListNode(4);

        first.next = second;
        second.next = three;
         three.next = four;


        ListNode listNode = swapPairs(first);
        while (listNode != null) {
            System.out.println(listNode.dispaly());
            listNode = listNode.next;
        }


    }

}
