package codingninja.triesAndHuffmanCoding;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("ar");
        trie.add("arj");
        trie.add("rj");
        System.out.println(trie.search("rj"));
        trie.remove("rj");
        System.out.println(trie.search("rj"));
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
    private void remove(TrieNode root, String str) {
        if (str.length() == 0 ) {
            root.isTerminal = false;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child != null)
            remove(child, str.substring(1));
    }

    public void remove( String str) {
        remove(root,str);
    }


    public boolean search(String str) {
        return search(root, str);
    }

    public void add(String str) {
        add(root, str);
    }
}
