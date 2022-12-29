package codingninja.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    T data;
    List<TreeNode<T>> children;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}
