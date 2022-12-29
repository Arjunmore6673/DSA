package codingninja.bst;

import java.util.Stack;


public class Bike extends Vehicle {


    public static NodeObj<Integer> insertEnd(NodeObj<Integer> head, int data) {
        if (head == null) return createNode(data);
        head.next = insertEnd(head.next, data);
        return head;
    }

    static NodeObj<Integer> createNode(int data) {
        return new NodeObj<Integer>(data);
    }

    public static NodeObj<Integer> insertAtPos(NodeObj<Integer> head, int data, int pos) {
        if (head == null && pos > 0) return head;
        if (pos == 0) {
            NodeObj<Integer> nodeObj = createNode(data);
            nodeObj.next = head;
            return nodeObj;
        } else {
            NodeObj<Integer> newNodeObj = insertAtPos(head.next, data, pos - 1);
            head.next = newNodeObj;
            return head;
        }
    }

    public static NodeObj<Integer> deleteLast(NodeObj<Integer> head) {
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        head.next = deleteLast(head.next);
        return head;
    }

    public static NodeObj<Integer> deleteKthNode(NodeObj<Integer> head, int k) {
        if (head == null && k > 0) return head;
        if (k == 0) {
            head = head.next;
            return head;
        }
        head.next = deleteKthNode(head.next, k - 1);
        return head;
    }

    static void print(NodeObj<Integer> head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        print(head.next);
    }

    static NodeObj<Integer> reverse(NodeObj<Integer> head) {
        if (head == null || head.next == null) return head;
        NodeObj<Integer> reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    public static boolean isBalanced(String expression) {
        boolean isValid = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
//            System.out.print("  " + c);
            if (c == '(') {
//                System.out.println("adding " + c);
                stack.push(c);
            } else if (c == ')') {
//                System.out.println("stack else" + c);
                if (stack.isEmpty())
                    return false;
                char cpop = stack.pop();
//                System.out.println("stack else " + cpop + " =>" + c);
                if (c == ')' && cpop != '(')
                    return false;
            }
        }
        return isValid;
    }

    public static NodeObj<Integer> swapNodes(NodeObj<Integer> head, int i, int j) {
        if (head == null) return head;
        if (i == j) return head;
        NodeObj<Integer> headTemp = head;

        NodeObj<Integer> firstCurr = null;
        NodeObj<Integer> firstPrev = null;
        NodeObj<Integer> secondCurr = null;
        NodeObj<Integer> secondPrev = null;

        for (int x = 0; headTemp != null; x++) {
            if (x == i - 1) {
                firstPrev = headTemp;
                firstCurr = headTemp.next;
            }
            if (x == j - 1) {
                secondPrev = headTemp;
                secondCurr = headTemp.next;
            }
            if (firstCurr != null && secondCurr != null)
                break;
            headTemp = headTemp.next;

        }


        if (firstPrev != null)
            firstPrev.next = secondCurr;
        if (secondPrev != null)
            secondPrev.next = firstCurr;
        NodeObj<Integer> temp = firstCurr.next;
        firstCurr.next = secondCurr.next;
        secondCurr.next = temp;


//        System.out.println(firstCurr.data);
//        System.out.println(secondCurr.data);


        return head;
    }
    public static NodeObj<Integer> swapNodes2(NodeObj<Integer> head, int i, int j) {
        if (head == null) return head;
        if (i == j) return head;
        NodeObj<Integer> headTemp = head;

        NodeObj<Integer> firstCurr = null;
        NodeObj<Integer> firstPrev = null;
        NodeObj<Integer> secondCurr = null;
        NodeObj<Integer> secondPrev = null;

        for (int x = 0; headTemp != null; x++) {
            if (x == i - 1) {
                firstPrev = headTemp;
                firstCurr = headTemp.next;
            }
            if (x == j - 1) {
                secondPrev = headTemp;
                secondCurr = headTemp.next;
            }
            if (firstCurr != null && secondCurr != null)
                break;
            headTemp = headTemp.next;

        }


        if (firstPrev != null)
            firstPrev.next = secondCurr;
        if (secondPrev != null)
            secondPrev.next = firstCurr;
        NodeObj<Integer> temp = firstCurr.next;
        firstCurr.next = secondCurr.next;
        secondCurr.next = temp;


//        System.out.println(firstCurr.data);
//        System.out.println(secondCurr.data);


        return head;
    }

    static NodeObj<Integer> reverse(NodeObj<Integer> head, int k) {
        if (head == null) return null;

        NodeObj<Integer> current = head;
        NodeObj<Integer> next = null;
        NodeObj<Integer> prev = null;

        int count = 0;
        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    public static int getLen(NodeObj<Integer> head) {
        if (head == null) return 0;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static NodeObj<Integer> bubbleSort(NodeObj<Integer> head) {
        if (head == null) return null;
        int length = getLen(head);
        for (int i = 0; i < length - 1; i++) {
            NodeObj<Integer> curr = head;
            NodeObj<Integer> prev = null;
            NodeObj<Integer> next = curr.next;

            while (curr.next != null) {
                if (curr.data > (int) curr.next.data) {
                    if (prev == null) {
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                        head = prev;
                    } else {
                        next = curr.next;
                        curr.next = next.next;
                        prev.next = next;
                        next.next = curr;
                        prev = next;
                    }
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }


    public static NodeObj<Integer> swapNodeData(NodeObj<Integer> head, int x, int y) {
        // Nothing to do if x and y are same
        if (x == y)
            return head;

        // Search for x (keep track of prevX and CurrX)
        NodeObj<Integer> prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        NodeObj<Integer> prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return head;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        NodeObj<Integer> temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("()"));
//        Node<Integer> head = null;
//        head = insertEnd(head, 1);
//        head = insertEnd(head, 2);
//        head = insertEnd(head, 3);
//        head = insertEnd(head, 11);
//        head = insertEnd(head, 211);
//
//        print(head);
//        System.out.println();
////        head = insertAtPos(head, 11, 11);
////        print(deleteLast(head));
//        print(reverse(head));

//        StackUsingArray stackUsingArray = new StackUsingArray();
//        stackUsingArray.push(10);
//        stackUsingArray.push(110);
//
//        System.out.println(stackUsingArray.size());;
//        System.out.println(stackUsingArray.isEmpty());;
//        System.out.println(stackUsingArray.top());;
//        stackUsingArray.pop();
//        stackUsingArray.pop();
//        System.out.println(stackUsingArray.top());;
//        System.out.println(stackUsingArray.isEmpty());;
//        StackUsingLL<Integer> stackUsingLL = new StackUsingLL<>();
//        stackUsingLL.push(10);
//        stackUsingLL.push(22);
//        stackUsingLL.push(11);
//        stackUsingLL.pop();
//        stackUsingLL.pop();
////        stackUsingLL.pop();
//        Stack<Integer> stack = new Stack<>();
//        System.out.println(stack.pop());

//        QueueArr queueArr = new QueueArr();
//        queueArr.enqueue(1);
//        queueArr.enqueue(11);
//        queueArr.enqueue(21);
//        queueArr.dequeue();
//        queueArr.dequeue();
//        queueArr.dequeue();
//        queueArr.enqueue(21);
//        queueArr.enqueue(33);
//        System.out.println(queueArr.front());


        NodeObj<Integer> data = new NodeObj<>(3);
        NodeObj<Integer> data1 = new NodeObj<>(4);
        NodeObj<Integer> data2 = new NodeObj<>(5);
        NodeObj<Integer> data3 = new NodeObj<>(2);
        NodeObj<Integer> data4 = new NodeObj<>(6);
        NodeObj<Integer> data5 = new NodeObj<>(1);
        NodeObj<Integer> data6 = new NodeObj<>(9);
        data.next = data1;
        data1.next = data2;
        data2.next = data3;
        data3.next = data4;
        data4.next = data5;
        data5.next = data6;
        print(data);
//        System.out.println();
//        NodeObj<Integer> rev = reverse(data, 2);
//        System.out.println();
//        print(rev);
//        System.out.println();
//
        System.out.println();
//        print(bubbleSort(rev));

        print(swapNodeData(data, 1, 3));

    }
}
