/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miqdad
 */
class Node {

    Node left, right;
    int value;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value && this.left != null) {
            this.left.search(value);
        } else if (value > this.value && this.right != null) {
            this.right.search(value);
        }

        return null;
    }

    private void visit() {
        if (this.left != null) {
            this.left.visit();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.visit();
        }
    }

    private void addNode(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
    }
}

class Tree {

    Node root;

    private void addValue(int value) {
        Node node = new Node(value);
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
    }

    private void binaryTreeSort() {
        this.root.visit();
    }
}

public class BinaryTree {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 5, 6, 7, 1, 9, 0 };
        Tree tree = new Tree();
        for (int n : nums) {
            tree.addValue(n);
        }

        tree.binaryTreeSort();
        System.out.println("");
    }
}
