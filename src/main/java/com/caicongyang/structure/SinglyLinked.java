package com.caicongyang.structure;

/**
 * 单链表
 */
public class SinglyLinked {


    /**
     * 链表的头结点
     */
    private  ListNode head = null;



    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }




    /**
     * 链表添加结点:
     * 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
     *
     * @param data
     */
    public void addNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }




    public int delNode(int index){
        //待删除结点不存在
        if(index<1 || index>length()){
            return 0;
        }
        //删除头结点
        if(index == 1){
            head = head.next;
            return 1;
        }
        ListNode preNode = head;
        ListNode currentNode = preNode.next;
        int i = 1;
        while(currentNode != null){
            if(i==index){//寻找到待删除结点
                preNode.next = currentNode.next;//待删除结点的前结点指向待删除结点的后结点
                return 1;
            }
            //当先结点和前结点同时向后移
            preNode = preNode.next;
            currentNode = currentNode.next;
            i++;
        }
        return 0;
    }











    /**
     * 求链表的长度
     * @return
     */
    public int length(){
        int length = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }



}
