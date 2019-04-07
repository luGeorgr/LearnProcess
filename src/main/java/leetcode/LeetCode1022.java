package leetcode;

import lombok.val;

public class LeetCode1022 {

    private int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        if (root != null) {
            visit(root, 0);
        }
        return sum;
    }

    private void visit(TreeNode root, int value) {
        value = value * 2 + root.val;
        if (root.left == null && root.right == null) {
            sum += value;
            return;
        }
        if (root.left != null) {
            visit(root.left, value);
        }
        if (root.right != null) {
            visit(root.right, value);
        }
    }

}
