package leetcode;

public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        rotate(root);
    }

    private TreeNode rotate(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left != null && root.right == null) {
            TreeNode left = rotate(root.left);
            root.right = root.left;
            root.left = null;
            return left;
        } else if (root.left == null && root.right != null) {
            return rotate(root.right);
        } else {
            TreeNode left = rotate(root.left);
            TreeNode right = rotate(root.right);
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            return right;
        }
    }
}
