package youtube;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeExample {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        int index = 0;

        public Node insertNode(Node node, int value) {
            if (node == null) {
                node = new Node(value);
                return node;
            }
            if (value < node.data)
                node.left = insertNode(node.left, value);
            if (value > node.data)
                node.right = insertNode(node.right, value);
            return node;
        }


        public boolean searchNode(Node node, int value) {
            if (node == null)
                return false;
            if (node.data == value)
                return true;
            return searchNode(node.left, value) || searchNode(node.right, value);
        }

        //if node is leaf node then no extra logic.
        //if node node has children
        public Node deleteNode(Node node, int value) {

            if (node.data > value) {
                node.left = deleteNode(node.left, value);
            } else if (node.data < value) {
                node.right = deleteNode(node.right, value);
            } else {
//                node to be deleted.
                /// if leaf node.
                if (node.left == null && node.right == null)
                    return null;
                /// if one child node.
                if (node.left == null)
                    return node.right;
                if (node.right == null)
                    return node.left;
                /// if has two child.

                Node newNode = rightSmallest(node.right);
                node.data = newNode.data;
                node.right = deleteNode(newNode, node.data);
            }
            return node;
        }

        private Node rightSmallest(Node right) {
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }


        public void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(" " + node.data);
            inOrder(node.right);
        }


        public void printInRange(Node root, int X, int Y) {
            if (root == null)
                return;
            if (X <= root.data && Y >= root.data) {
                printInRange(root.left, X, Y);
                System.out.print(root.data + " ");
                printInRange(root.right, X, Y);
            } else if (Y <= root.data) {
                printInRange(root.left, X, Y);
            } else {
                printInRange(root.right, X, Y);
            }
        }

    }

    public static void main(String[] args) {
        int[] nodes = {5, 1, 3, 4, 2, 7};
        BinaryTree binaryTree = new BinaryTree();
        Node node = null;
        for (int i : nodes)
            node = binaryTree.insertNode(node, i);
        binaryTree.inOrder(node);
        System.out.println();
        binaryTree.deleteNode(node, 5);
        binaryTree.inOrder(node);
        System.out.println();
        System.out.println();
        binaryTree.printInRange(node, 1, 5);
    }

}

