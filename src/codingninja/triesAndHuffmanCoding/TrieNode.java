package codingninja.triesAndHuffmanCoding;

import java.util.Arrays;

public class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode[] children;
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminal = false;
        children = new TrieNode[26];
        childCount = 0;
    }

    @Override
    public String toString() {
        return "TN{" +
                "data=" + data +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
