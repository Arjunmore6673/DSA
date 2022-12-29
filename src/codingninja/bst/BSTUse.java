package codingninja.bst;

public class BSTUse {
    public static void main(String[] args) {

        BST b = new BST();
        b.insert(4);
        b.insert(3);
        b.insert(2);
        b.insert(1);
        b.insert(12);
        b.insert(14);
        b.insert(11);
        b.printTree();
        b.constructLinkedListForEachLevel();
//        System.out.println(b.isPresent(3));
//        b.delete(3);
//        System.out.println(b.isPresent(3));
     //   b.printTree();
    }
}
