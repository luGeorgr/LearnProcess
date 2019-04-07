package leetcode;

import java.util.Stack;

public class LeetCode538 {
    public TreeNode convertBST(TreeNode root) {
        visit(root);
        return root;
    }

    private void visit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        visit(root, stack);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sum += node.val;
            node.val = sum;
        }
    }

    private void visit(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        visit(root.left, stack);
        stack.push(root);
        visit(root.right, stack);
    }
}
