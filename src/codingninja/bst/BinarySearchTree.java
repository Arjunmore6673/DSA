package codingninja.bst;

public class BinarySearchTree {
    private static int maximum(BinaryTreeNode<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        int maxLeft = maximum(root.left);
        int maxRight = maximum(root.right);
        return Math.max(root.data, Math.max(maxLeft, maxRight));
    }

    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;
        int minLeft = minimum(root.left);
        int minRight = minimum(root.right);
        return Math.min(root.data, Math.min(minLeft, minRight));
    }


    private static Boolean checkBST(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
//        check root is bigger than child nodes
//        we will find out max and min value of that subtree, tree
        int leftMax = maximum(root.left);
//        everything from left of node should be smaller than root node if not we will return false.
        if (leftMax >= root.data)
            return false;
        int rightMin = minimum(root.right);
        if (rightMin < root.data)
            return false;
        return checkBST(root.left) && checkBST(root.right);
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
//        BinaryTreeNode<Integer> one = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> two = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> three = new BinaryTreeNode<>(3);
//        BinaryTreeNode<Integer> four = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> five = new BinaryTreeNode<>(5);
//        root.left = one;
//        root.right = two;
//        root.left.left = three;
//        root.left.right = four;
//        root.right.left = five;
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> c= new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> d= new BinaryTreeNode<>(16);
        root.left = a;
        root.left.right = b;
        root.right = c;
        root.right.left = d;
        System.out.println(checkBST(root));
        preorder(root);
    }

    private static void preorder(BinaryTreeNode<Integer> root) {
        if(root==null) return;
        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
    }


}
