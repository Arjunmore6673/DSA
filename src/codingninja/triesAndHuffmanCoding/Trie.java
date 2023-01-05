package codingninja.triesAndHuffmanCoding;

import java.util.ArrayList;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("ar");
        trie.add("arj");
        trie.add("rj");
//        System.out.println(trie.search("ar"));
        trie.add("pq");
//        System.out.println(trie.search("ar"));
//        System.out.println(trie.search("arj"));
        System.out.println(trie.wordCount());
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("defa");
        list.add("deffaaa");
        list.add("ba");
        list.add("bac");
        list.add("baar");
//        System.out.println(trie.patternMatching(list, "hi"));
//        System.out.println(trie.isPalindromePair(list));
        trie.autoComplete(list, "ba");
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    private void add(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminal = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
            child.childCount++;
        }
        add(child, str.substring(1));
    }

    public boolean search(TrieNode root, String str) {
        if (str.length() == 0 && root.isTerminal)
            return true;
        if (str.length() == 0)
            return false;
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return false;
        else {
            return search(child, str.substring(1));
        }
    }

    public TrieNode autoCompleteSearch(TrieNode root, String str) {
        if (str.length() == 0)
            return root;
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return null;
        else {
            return autoCompleteSearch(child, str.substring(1));
        }
    }

    public void print(TrieNode root, String word, String output) {
        if (root == null)
            return;
        if (root.isTerminal)
            System.out.println(word + output);
        for (int i = 0; i < root.children.length; i++) {
            TrieNode node = root.children[i];
            if (node != null) {
                String ans = output + node.data;
                print(node,word,ans);
            }
        }
    }

    public void autoComplete(ArrayList<String> input, String word) {
        for (String str : input)
            add(str);
        TrieNode trieNode = autoCompleteSearch(root, word);
        print(trieNode, word, "");
    }

    private String reverse(String str) {
        if (str.equals("")) return "";
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public boolean isPalindromePair(ArrayList<String> words) {
        Trie trie = new Trie();
        for (String str : words) {
            String reversed = reverse(str);
            for (int i = 0; i < str.length(); i++)
                trie.add(reversed.substring(i));
        }
        for (String word : words) {
            if (trie.search(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean patternMatching(ArrayList<String> input, String pattern) {
        for (String str : input) {
            Trie suffixTrie = new Trie();
            for (int j = 0; j < str.length(); j++)
                suffixTrie.add(str.substring(j));
            System.out.println(suffixTrie);
            if (suffixTrie.search(pattern))
                return true;
        }
        return false;
    }

    private void remove(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminal = false;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child != null) {
            remove(child, str.substring(1));
            if (!child.isTerminal && child.childCount == 0) {
                child.children[childIndex] = null;
                child.childCount--;
            }
        }
    }

    public void remove(String str) {
        remove(root, str.toLowerCase());
    }

    private int wordCount(TrieNode root) {
        int count = 0;
        if (root.isTerminal) {
            count++;
        }
        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                count += wordCount(root.children[i]);
        return count;
    }

    public int wordCount() {
        int count = 0;
        if (root.isTerminal) {
            count++;
        }
        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                count += wordCount(root.children[i]);
        return count;
    }

    public boolean search(String str) {
        return search(root, str);
    }

    public void add(String str) {
        add(root, str);
    }
}
