package com.caicongyang.structure;

/**
 * 双向链表
 */
public class DoublyLinkedList {


    /**
     * 链表的头结点
     */
    private DoublyLinkedNode head = null;

    private DoublyLinkedNode tail = null;


    /**
     * 链表
     * 头部插入
     *
     * @param data
     */
    public void insertHeadNode(int data) {

        DoublyLinkedNode newNode = new DoublyLinkedNode(data);


        if (head == null) {
            tail = newNode;
            head = newNode;
        } else {
            head.pre = newNode;
            newNode.next = head;
            head = newNode;
        }

    }

    /**
     * 删除尾结点
     */
    public void deleteTail() {

        if(tail == null){
            return;
        }
        tail.pre.next  = null;
        tail =  tail.pre;

    }


    private void print(){

        DoublyLinkedNode cur = head;

        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

    class DoublyLinkedNode {
        int val;
        DoublyLinkedNode next;
        DoublyLinkedNode pre;


        DoublyLinkedNode(int x) {
            val = x;
            next = null;
            pre = null;
        }
    }


    public static void main(String[] args) {

        DoublyLinkedList dlinkedList = new DoublyLinkedList();
        dlinkedList.insertHeadNode(2);
        dlinkedList.insertHeadNode(3);
        dlinkedList.insertHeadNode(4);

//
//        dlinkedList.print();
//
//
//        System.out.println("---------");

        dlinkedList.deleteTail();

        dlinkedList.print();


    }
}
