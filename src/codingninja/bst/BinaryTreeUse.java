package codingninja.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of" + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;

    }

    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;

    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data);
        if (root.left != null) {
            System.out.print(" L:" + root.left.data);
            if (root.right != null) {
                System.out.print(",R:" + root.right.data);
            } else System.out.print(" -");
        } else System.out.print(" -");
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static void printNodeDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printNodeDepthK(root.left, k - 1);
        printNodeDepthK(root.right, k - 1);
    }


    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        int leftNodeCount = numNodes(root.left);
        int rightNodeCount = numNodes(root.right);
        return 1 + leftNodeCount + rightNodeCount;
    }

    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }

    public static int numLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return numLeaves(root.left) + numLeaves(root.right);
    }

    public static BinaryTreeNode<Integer> getLevelWise() {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            System.out.println("enter left of " + node.data);
            int left = scanner.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(left);
                root.left = leftNode;
                queue.add(leftNode);
            }
            System.out.println("enter right of " + node.data);
            int right = scanner.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(right);
                root.right = rightNode;
                queue.add(rightNode);
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            System.out.print(node.data + " L:");
            if (node.left != null) {
                System.out.print(node.left.data + "R:");
                queue.add(node.left);
            }
            if (node.right != null) {
                System.out.print(node.right.data);
                queue.add(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
//
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
//        root.left = rootLeft;
//        root.right= rootRight;
//
//
//        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
//        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
//
//        rootLeft.right= twoRight;
//        rootRight.left= threeLeft;
//
//        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
//        System.out.println("Num nodes " + numNodes(root));
//        System.out.println("Largest is " + largest(root));
//        BinaryTreeNode<Integer> root = takeTreeInput();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> one = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<>(5);
        root.left = one;
        root.right = two;
        root.left.left = three;
        root.left.right = four;
        root.right.left = five;
//        BinaryTreeNode<Integer> root = getLevelWise();
//        printLevelWise(root);
    }
}
