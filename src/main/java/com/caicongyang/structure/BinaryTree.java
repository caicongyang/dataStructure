package com.caicongyang.structure;

import com.caicongyang.structure.TreeNode;

/**
 * 二叉树
 *
 * @param <T>
 */
public class BinaryTree<T> {

    /**
     * 保存树的根
     */
    TreeNode root;


    //查找节点
    public TreeNode find(Integer key) {
        TreeNode current = root;
        while (current != null) {
            if (current.key > key) {//当前值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.key < key) {//当前值比查找值小，搜索右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回null
    }


    //插入节点
    public boolean insert(int key, T value) {
        TreeNode newNode = new TreeNode(key, value);
        if (root == null) {//当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            TreeNode current = root;
            TreeNode parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.key > key) {//当前值比插入值大，搜索左子节点
                    current = current.leftChild;
                    if (current == null) {//左子节点为空，直接将新值插入到该节点
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {//右子节点为空，直接将新值插入到该节点
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //中序遍历
    public void infixOrder(TreeNode current) {
        if (current != null) {
            infixOrder(current.leftChild);
            current.display();
            infixOrder(current.rightChild);
        }
    }

    //前序遍历
    public void preOrder(TreeNode current) {
        if (current != null) {
            current.display();
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    /**
     * 后续遍历
     * 先遍历左节点，再遍历右节点，最终遍历当前节点
     *
     * @param current
     */
    public void postOrder(TreeNode current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            current.display();

        }
    }


    //找到最大值
    public TreeNode findMax() {
        TreeNode current = root;
        TreeNode maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //找到最小值
    public TreeNode findMin() {
        TreeNode current = root;
        TreeNode minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }


}
