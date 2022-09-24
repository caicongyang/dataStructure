package com.caicongyang.tree;

public class BinaryTree {

    public void print(TreeNode node) {
        System.out.println(node.getVal());
    }

    /**
     * 前序遍历：根节点->左子树->右子树（根->左->右）
     *
     * @param root
     */
    public void preSort(TreeNode root) {
        print(root);
        if (root.getLeft() != null) {
            print(root.getLeft());
        }
        if (root.getRight() != null) {
            print(root.getRight());
        }

    }

    /**
     * 后序遍历： 左子树->右子树-> 根（左 -> 右-> 根）
     *
     * @param root
     */
    public void postSort(TreeNode root) {

        if (root.getLeft() != null) {
            print(root.getLeft());
        }
        if (root.getRight() != null) {
            print(root.getRight());
        }
        print(root);
    }

    /**
     * 中序遍历：左子树-> 根 ->右子树
     *
     * @param root
     */
    public void inSort(TreeNode root) {
        if (root.getLeft() != null) {
            print(root.getLeft());
        }
        print(root);
        if (root.getRight() != null) {
            print(root.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode D = new TreeNode('D', null, null);
        TreeNode H = new TreeNode('H', null, null);
        TreeNode K = new TreeNode('K', null, null);
        TreeNode C = new TreeNode('C', D, null);
        TreeNode G = new TreeNode('G', H, K);
        TreeNode B = new TreeNode('B', null, C);
        TreeNode F = new TreeNode('F', G, null);
        TreeNode E = new TreeNode('E', null, F);
        TreeNode A = new TreeNode('A', B, E);

        BinaryTree binaryTree = new BinaryTree();
        System.out.println("前");
        binaryTree.preSort(A);
        System.out.println();
        System.out.println("中");
        binaryTree.inSort(A);
        System.out.println();
        System.out.println("后");
        binaryTree.postSort(A);


    }


}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
