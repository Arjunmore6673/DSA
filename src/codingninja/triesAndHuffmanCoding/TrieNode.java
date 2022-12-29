package codingninja.triesAndHuffmanCoding;

import java.util.Arrays;

public class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode[] children;

    public TrieNode(char data) {
        this.data = data;
        isTerminal = false;
        children = new TrieNode[26];
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "data=" + data +
                ", isTerminal=" + isTerminal +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
