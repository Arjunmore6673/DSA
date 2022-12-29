package codingninja.bst;

import java.util.Arrays;

public class StackUsingArray {
    private int arr[];
    private int index;

    StackUsingArray(){
        this.arr = new int[10];
        index = -1;
    }

    public void push(int value) {
        index++;
        arr[index] = value;
        System.out.println(Arrays.toString(arr));
    }

    public int top() {
        if(index == -1) return index;
        return arr[index];
    }

    public int size() {
        return index+1;
    }

    public void pop() {
        arr[index]= 0;
        index--;
    }

    public boolean isEmpty() {
        return index == -1;
    }
}
