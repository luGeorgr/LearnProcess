package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode94 {
    private List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(final TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
