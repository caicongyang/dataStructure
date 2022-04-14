package com.caicongyang.leetcodee;

/**
 * Josephus Problem
 * 约瑟夫问题
 * <p>
 * N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的人的序号为5，4，6，2，3。最后剩下1号。
 * <p>
 * 请输出被杀掉的顺序
 */
public class CircleLinkedList {

    private SinglyLinkNode first = null;


    public CircleLinkedList() {

    }

    /**
     * 购买一个循环单向链表
     *
     * @param n
     */
    public void init(int n) {
        if (n < 1) {
            return;
        }
        SinglyLinkNode cur = null;
        for (int i = 1; i <= n; i++) {
            SinglyLinkNode newNode = new SinglyLinkNode(i);
            if (i == 1) {
                first = newNode;
                // 构建一个节点的环
                newNode.next = first;
                cur = newNode;
                continue;
            }
            //往后添加节点
            cur.next = newNode;
            newNode.next = first;
            // cur 指向最后一个节点
            cur = newNode;

        }
    }

    /**
     * 移动多少位，然后出圈
     *
     * @param m
     */
    public void play(int m) {

        // 寻找最后一个节点
        SinglyLinkNode last = first;
        while (true) {
            if (last.next == first) {
                break;
            }
            last = last.next;
        }

        while (true) {
            if (last == first) {
                break;
            }
            // 移动m次
            for (int i = 0; i < m - 1; i++) {
                first = first.next; // FIRST节点后移
                last = last.next; // lastNode节点后移
            }
            // first出圈
            System.out.println(first.data + "out");
            first = first.next;
            last.next = first;
        }

        System.out.println(first.getData() + "最后留下！");
    }

    public void print() {
        if (first == null) {
            return;
        }
        SinglyLinkNode cur = first;
        while (true) {
            System.out.println(cur.getData());
            if (cur.next == first) {
                break;
            }
            cur = cur.next;
        }

        System.out.println("--------");
    }


    class SinglyLinkNode {

        private int data;
        private SinglyLinkNode next;

        public SinglyLinkNode(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public SinglyLinkNode getNext() {
            return next;
        }

        public void setNext(SinglyLinkNode next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {

        CircleLinkedList linkedList = new CircleLinkedList();
        linkedList.init(6);


        linkedList.print();

        linkedList.play(5);

    }

}
