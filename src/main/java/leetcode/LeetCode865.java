package leetcode;

public class LeetCode865 {
    private int maxDepth;
    private TreeNode res;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth = 0;
        visit(root , 0);
        return res;
    }

    private int visit(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = visit(root.left, depth + 1);
        int right = visit(root.right, depth + 1);
        if (left == right && left >= maxDepth) {
            maxDepth = left;
            res = root;
        }
        return Math.max(left, right);
    }
}
