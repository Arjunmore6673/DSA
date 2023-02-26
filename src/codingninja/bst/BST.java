package codingninja.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;


    public BST() {
//        root = new BinaryTreeNode<>(10);
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(4);
//        root.left = a;
//        root.left.right = b;
//        root.right = c;
//        root.right.left = d;
    }

    private static LinkedListNode<Integer> insertAtEnd(LinkedListNode<Integer> head, int data) {
        LinkedListNode<Integer> node = head;
        LinkedListNode<Integer> prev = head;
        if(node == null) return new LinkedListNode<>(data);
        while (node !=null){
            prev = node;
            node = node.next;
        }
        prev.next = new LinkedListNode<>(data);
        return head;
    }
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root,
                                                                                     ArrayList<LinkedListNode<Integer>> list) {
        if (root == null) return null;
        Queue<BinaryTreeNode<Integer>> qu = new LinkedList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        qu.add(root);
        qu.add(null);
        while (!qu.isEmpty()) {
            BinaryTreeNode<Integer> node = qu.remove();
            if (node == null) {
                if(qu.isEmpty())
                    break;
                LinkedListNode<Integer> linkedListHead = new LinkedListNode<>(tempList.get(0));
                for (int i : tempList)
                    linkedListHead = insertAtEnd(linkedListHead,i);
                list.add(linkedListHead);
                qu.add(null);
            } else {
                tempList.add(root.data);
                if (node.left != null) {
                    qu.add(node.left);
                }
                if (node.right != null) {
                    qu.add(node.right);
                }
            }
        }
        return list;
    }



    private boolean isPresentHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) return false;
        if (root.data == data) return true;
        if (data > root.data)
            return isPresentHelper(data, root.right);
        if (data < root.data)
            return isPresentHelper(data, root.left);
        return false;
    }

    public boolean isPresent(int data) {
        return isPresentHelper(data, root);
    }

    private BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
        if (root == null)
            return new BinaryTreeNode<>(data);
        if (data <= root.data)
            root.left = insert(data, root.left);
        else if (data > root.data)
            root.right = insert(data, root.right);
        return root;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    private boolean delete(int data, BinaryTreeNode<Integer> root) {
        return false;
    }

    public boolean delete(int data) {
        return delete(data, root);
    }

    int getSize() {
        return size;
    }

    private void printTree(BinaryTreeNode<Integer> node) {
        if (node == null) return;
        System.out.print(node.data + ":");
        if (node.left != null)
            System.out.print("L:" + node.left.data + ", ");
        if (node.right != null)
            System.out.print("R:" + node.right.data);

        System.out.println();
        printTree(node.left);
        printTree(node.right);
    }

    void printTree() {
        printTree(root);
    }

    public ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel() {
        ArrayList<LinkedListNode<Integer>>  list = new ArrayList<>();
        return	 constructLinkedListForEachLevel(root,list);
    }
}
