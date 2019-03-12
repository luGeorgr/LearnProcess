package leetcode;

import java.util.List;

public class LeetCode559 {
    private int max;
    private int now;
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        now = 0;
        DFS(root);
        return max;
    }

    private void DFS(final Node root) {
        now += 1;
        if (root.children == null || root.children.size() == 0) {
            if (now > max) {
                max = now;
            }
            now -= 1;
            return;
        }
        for (final Node node : root.children) {
            DFS(node);
        }
        now -= 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
