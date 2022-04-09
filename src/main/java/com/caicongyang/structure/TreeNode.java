package com.caicongyang.structure;

/**
 * 二叉树节点类
 * @param <T>
 */
public class TreeNode<T> {

    Integer key;
    T value;
    TreeNode leftChild;
    TreeNode rightChild;


    boolean isDelete;//表示节点是否被删除,用作为伪删除


    public TreeNode(Integer key, T value) {
        this.value = value;
    }


    //打印节点内容
    public void display() {
        System.out.println(key + ":" + value);
    }

}
