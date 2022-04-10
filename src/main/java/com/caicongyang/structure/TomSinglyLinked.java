package com.caicongyang.structure;

/**
 * 单链表
 */
public class TomSinglyLinked {


    /**
     * 链表的头结点
     */
    private ListNode head = null;


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * 链表
     * 头部插入
     *
     * @param data
     */
    public void insertHeadNode(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }


    /**
     * 插入中间的某个位置
     *
     * @param data
     * @param pos
     */
    public void insertNth(int data, int pos) {
        if (pos == 0) {
            insertHeadNode(data);
        } else {
            ListNode cur = head;
            // 找到pos位置的前一个node
            for (int i = 0; i < pos; i++) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(data);
            // 新节点的next 指向后面，保证不断
            newNode.next = cur.next;
            // 当前节点的 next 指向new的节点
            cur.next = newNode;
        }
    }


    /**
     * 删除头结点
     */
    public void delHeadNode() {
        head = head.next;
    }

    /**
     * 删除某个位置的node
     *
     * @param pos
     */
    public void delNode(int pos) {
        if (pos == 0) {
            delHeadNode();
        } else {
            // 找到pos位置的前一个
            ListNode cur = head;
            for (int i = 0; i < pos; i++) {
                cur = cur.next;
            }

            cur.next = cur.next.next;
        }
    }


    /**
     * 删除某个数据的node
     */
    public void delData(int data) {

        if (head == null) {
            return;
        }

        if(head.val == data){
            head = head.next;
            return;
        }

        if(head.next.val == data){
            head.next = head.next.next;
            return;
        }

        // 找到data数据的前一个
        ListNode cur = head;
        while (cur.next.next != null) {
            if (cur.next.val == data) {
                break;
            }
            cur = cur.next;
        }

        cur.next = cur.next.next;

    }

    /**
     * 链表是否存在某个数据
     *
     * @param data
     * @return
     */
    public Boolean exist(int data) {
        if (head == null) {
            return false;
        }

        ListNode cur = head;
        while (cur != null) {
            if (data == cur.val) {
                return true;
            }
            cur = cur.next;
        }

        return false;

    }


    /**
     * 删除尾结点
     */
    public void delTail() {
        //0个节点
        if (head == null) {
            return;
        }

        //1个节点
        if (head.next == null) {
            head = null;
        }

        ListNode cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;


    }


    /**
     * 求链表的长度
     *
     * @return
     */
    public int length() {
        int length = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }


    /**
     * display
     */
    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

        System.out.println("--------");
    }


    public static void main(String[] args) {

        TomSinglyLinked linked = new TomSinglyLinked();
        linked.insertHeadNode(1);
        linked.insertHeadNode(2);
        linked.insertHeadNode(3);
        linked.insertHeadNode(4);

        linked.print();


//        linked.delData(4);

        linked.delData(1);

        linked.print();




    }


}
