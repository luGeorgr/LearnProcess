package leetcode;

public class LeetCode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }

        final int left;
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        } else {
            left = root.left.val;
        }

        final int right;
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        } else {
            right = root.right.val;
        }

        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            return left < right ? left : right;
        }
    }
}

