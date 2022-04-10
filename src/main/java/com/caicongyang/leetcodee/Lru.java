package com.caicongyang.leetcodee;

import com.caicongyang.structure.TomSinglyLinked;

/**
 * 新增加一个节点，遍历链表是否存在，如果存在着删除 ，并插入到头结点
 * <p>
 * 如果不存在则放到链表的最后一个节点，需要判断空间是否足够，如果不够的，需要删除尾结点
 */
public class Lru {

    //当前容器容量大小
    private Integer capacity = 4;

    private TomSinglyLinked linked;

    public Lru() {
        linked = new TomSinglyLinked();
    }

    public Integer putAndGet(int x) {
        if (linked.exist(x)) {
            linked.delData(x);
            linked.insertHeadNode(x);
        } else {
            if (linked.length() >= 4) {
                linked.delTail();
            }
            linked.insertHeadNode(x);
        }
        return x;
    }


    public Integer length() {
        return linked.length();
    }

    public void print(){
        linked.print();

    }
    public static void main(String[] args) {
        Lru lru = new Lru();
        lru.putAndGet(1);
        lru.putAndGet(2);
        lru.putAndGet(3);
        lru.putAndGet(4);
        lru.putAndGet(5);
        lru.putAndGet(1);
        lru.putAndGet(1);
//        System.out.println(lru.length());

        lru.print();



    }


}
