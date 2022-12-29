package youtube;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeExample {
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
        static int index = -1;
        //       creating tree.
        public Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1)
                return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        //Big O of n Linear order
        public void preOrder(Node node) {
            if (node == null) return;
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        //Big O of n
        public void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }

        //Big O of n
        public void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            System.out.print(node.data + " ");
            postOrder(node.right);
        }

        //Big O of n
        public void levelOrder(Node node) {
            if (node == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node currentNode = queue.remove();
                if (currentNode == null) {
                    System.out.println();
                    if (queue.isEmpty())
                        break;
                    else
                        queue.add(null);

                } else {
                    System.out.print(currentNode.data + " ");
                    if (currentNode.left != null)
                        queue.add(currentNode.left);
                    if (currentNode.right != null)
                        queue.add(currentNode.right);
                }
            }
        }


        public int nodeCount(Node node) {
            if (node == null) return 0;
            int left = nodeCount(node.left);
            int right = nodeCount(node.right);
            return left + right + 1;
        }


        public int sumCount(Node node) {
            if (node == null) return 0;
            int leftSum = sumCount(node.left);
            int rightSum = sumCount(node.right);
            return leftSum + rightSum + node.data;
        }

        public int nodeHeight(Node node) {
            if (node == null) return 0;
            int leftHeight = nodeHeight(node.left);
            int rightHeight = nodeHeight(node.right);
            return Math.max(leftHeight + 1, rightHeight + 1);
        }


        public int nodeDiameter(Node node) {
            if (node == null) return 0;
            int left = nodeDiameter(node.left);
            int right = nodeDiameter(node.right);
            return nodeHeight(node.left) + nodeHeight(node.right) + 1;
        }


        public Boolean subTreeValues(Node tree, Node subTree) {
            if (tree == null && subTree == null)
                return true;
            if (tree == null || subTree == null)
                return false;
            if (tree.data == subTree.data)
                return subTreeValues(tree.left, subTree.left) && subTreeValues(tree.right, subTree.right);
            return false;
        }

        public Boolean isSubTree(Node tree, Node subTree) {
            if (tree == null)
                return false;
            if (subTree == null)
                return true;
            if (tree.data == subTree.data) {
                if (subTreeValues(tree, subTree)) {
                    return true;
                }
            }
            return isSubTree(tree.left, subTree) || isSubTree(tree.right, subTree);
        }


        //Big O of n
        public int sumOfKthLevel(Node node, int k) {
            if (node == null) return 0;
            Queue<Node> queue = new LinkedList<>();
            if (k == 0) return node.data;
            int level = 1;
            int sum = 0;
            queue.add(node);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node currentNode = queue.remove();
                if (currentNode == null) {
                    if (queue.isEmpty())
                        break;
                    else {
                        queue.add(null);
                        level++;
                    }
                } else {
                    if (level == k)
                        sum += currentNode.data;
                    if (currentNode.left != null)
                        queue.add(currentNode.left);
                    if (currentNode.right != null)
                        queue.add(currentNode.right);
                }
            }
            return sum;
        }

    }

    public static void main(String[] args) {
//        1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1,};

        BinaryTree binaryTree = new BinaryTree();
        Node node = binaryTree.buildTree(nodes);

        Node subTree = new Node(3);
        subTree.right = new Node(16);
//        binaryTree.preOrder(node);
//        System.out.println();
//        binaryTree.inOrder(node);
//        binaryTree.levelOrder(node);
//        System.out.println(binaryTree.nodeCount(node));
//        System.out.println(binaryTree.sumCount(node));
//        System.out.println(binaryTree.nodeHeight(node));
//        System.out.println(binaryTree.nodeDiameter(node));
//        System.out.println(binaryTree.isSubTree(node, subTree));
        System.out.println(binaryTree.sumOfKthLevel(node, 3));
    }

}
