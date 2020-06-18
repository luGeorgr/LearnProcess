package leetcode;

public class LeetCode1302 {
    private int deepest = 0;
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return sum;
    }

    private void deepestLeavesSum(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > deepest) {
                deepest = deep;
                sum = root.val;
            } else if (deep == deepest) {
                sum += root.val;
            }
        }
        deepestLeavesSum(root.left, deep + 1);
        deepestLeavesSum(root.right, deep + 1);
    }
}

