package codingninja.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeMain {


    public static TreeNode<Integer> secondLargest;

    private static void printTreeDetailed(TreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + ":");
        for (TreeNode<Integer> node : root.children)
            System.out.print(node.data + " ");
        System.out.println();

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            printTreeDetailed(node);
        }
    }

    private static void printTree(TreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            printTree(node);
        }
    }

    private static int countNodes(TreeNode<Integer> root) {
        if (root == null) return 0;
//        root node count
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            int childCount = countNodes(root.children.get(i));
            count += childCount;
        }
        return count;
    }

    private static int sumNodes(TreeNode<Integer> root) {
        if (root == null) return 0;
        int sum = root.data;
        for (TreeNode<Integer> node : root.children) {
            int nodeSum = sumNodes(node);
            sum += nodeSum;
        }
        return sum;
    }

    private static TreeNode<Integer> inputTreeNode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter root data");
        int data = scanner.nextInt();
        if (data == -1) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(data);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            System.out.println("count of child nodes of " + node.data);
            int count = scanner.nextInt();
            if (count > 0) {
                for (int i = 1; i <= count; i++) {
                    System.out.println("Enter " + i + "th Child data of " + node.data);
                    int child = scanner.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    node.children.add(childNode);
                    queue.add(childNode);
                }
            }
        }
        return root;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root,
                                               TreeNode<Integer> maxSumRoot, int sum) {
        if (root == null) return maxSumRoot;
        int currentSum = root.data;

        for (int i = 0; i < root.children.size(); i++)
            currentSum += root.children.get(i).data;

        if (currentSum > sum) {
            sum = currentSum;
            maxSumRoot = root;
            maxSumRoot.data = root.data;
        }

        for (int i = 0; i < root.children.size(); i++)
            maxSumRoot = maxSumNode(root.children.get(i), maxSumRoot, sum);

        return maxSumRoot;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        return maxSumNode(root, null, 0);
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) return true;
        if (root1.data != root2.data) return false;
        for (int i = 0, j = 0; i < root1.children.size() && j < root2.children.size(); i++, j++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(j))) {
                return false;
            }
        }
        return true;
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n,
                                                       ArrayList<TreeNode<Integer>> largeNode) {
        if (root == null) return null;
        if (root.data > n) {
            largeNode.add(root);
        }
        for (TreeNode<Integer> node : root.children) {
            root = findNextLargerNode(node, n, largeNode);
        }
        return root;
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        ArrayList<TreeNode<Integer>> list = new ArrayList<>();
        findNextLargerNode(root, n, list);
        TreeNode<Integer> next = new TreeNode<>(Integer.MAX_VALUE);
        for (TreeNode<Integer> node : list) {
            if (node.data < next.data)
                next = node;
        }
        return next;
    }
    static TreeNode<Integer> largest = new TreeNode<>(Integer.MIN_VALUE);
    static TreeNode<Integer> smaller = new TreeNode<>(Integer.MIN_VALUE);
    public static void findSecondLargest(TreeNode<Integer> root, int n) {
        if (root == null) return;
        if (root.data > largest.data) {
            smaller = largest;
            largest = root;
        }
        if (root.data != largest.data && root.data > smaller.data) {
            smaller = root;
        }
        for (TreeNode<Integer> node : root.children) {
            findSecondLargest(node, n);
        }
    }


    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        TreeNode<Integer> largest = new TreeNode<>(Integer.MIN_VALUE);
        findSecondLargest(root, 2);
        System.out.println(smaller.data + " TreeNode<Integer>");
        return smaller;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> root1 = new TreeNode<>(2);
        TreeNode<Integer> root2 = new TreeNode<>(3);
        TreeNode<Integer> root3 = new TreeNode<>(21);
        TreeNode<Integer> root4 = new TreeNode<>(35);
        TreeNode<Integer> root5 = new TreeNode<>(16);
        root.children.add(root1);
        root.children.add(root2);
        root.children.add(root3);
        /*
         *        4
         *   /   /  /
         * 2    3   1
         *    / /
         *   5  6
         */
        root2.children.add(root4);
        root2.children.add(root5);
//        printTree(root);
//        printTreeDetailed(root);
//        System.out.println("Node count " + countNodes(root));
//        System.out.println("Node sum " + sumNodes(root));
//        System.out.println(maxSumNode(root).data);
//        System.out.println(findNextLargerNode(root, 35).data);
//        TreeNode<Integer> res = findNextLargerNode(root, 20);
        TreeNode<Integer> res = findSecondLargest(root);
//        System.out.println(res != null ? res.data : "");

    }

    static class NextLarger<T> {
        TreeNode<T> node;
        int data;

        public NextLarger(TreeNode<T> node, int data) {
            this.node = node;
            this.data = data;
        }

        public NextLarger() {
        }
    }
}
