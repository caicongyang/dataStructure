package com.caicongyang.leetcodee;

/**
 * 反转单链表
 * <p>
 * 输入: 9->6->5-> NULL
 * 输出: 5->6->9->NULL
 * <p>
 * 后继结点变成前继节点
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        // 如果只有一个节点则返回当前节点
        if (null == head.next) {
            return head;
        }

        //变量：当前节点
        ListNode currentNode = head;
        //变量：前置节点
        ListNode preNode = null;
        while (null != currentNode) {
            //找到原节点的后置节点保存到临时变量中
            ListNode nextTemp = currentNode.next; // 6 -> 5  -> null
            //当前节点的下一个节点为 前置节点（反转）
            currentNode.next = preNode; // null  -> 9  -> 6
            //
            preNode = currentNode;  // 9  -> 6 -> 5
            currentNode = nextTemp;  // 6  -> 5   --> null

        }
        return preNode;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(6);
        ListNode three = new ListNode(5);
        first.next = second;
        second.next = three;


        ListNode listNode = reverseList(first);
        while (listNode != null) {
            System.out.println(listNode.dispaly());
            listNode = listNode.next;
        }


    }

}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int dispaly() {
        return val;
    }

}

