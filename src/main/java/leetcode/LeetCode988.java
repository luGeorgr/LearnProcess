package leetcode;

import java.util.Stack;

public class LeetCode988 {
    public String smallestFromLeaf(TreeNode root) {
        return visit(root, new StringBuilder()).toString();
    }

    private StringBuilder visit(TreeNode root, StringBuilder stack) {
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            builder.append((char)('a' + root.val));
            return builder;
        }
        StringBuilder res;
        stack.append((char)('a' + root.val));
        if (root.left == null) {
            res = visit(root.right, stack);
        } else if (root.right == null) {
            res = visit(root.left, stack);
        } else {
            StringBuilder left = visit(root.left, stack);
            StringBuilder right = visit(root.right, stack);
            String suffix = stack.reverse().toString();
            stack.reverse();
            res = (left + suffix).compareTo(right + suffix) < 0 ? left : right;
        }
        res.append((char)('a' + root.val));
        stack.deleteCharAt(stack.length() - 1);
        return res;
    }
}
