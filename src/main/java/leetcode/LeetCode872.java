package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        final List<Integer> res1 = new ArrayList<>();
        final List<Integer> res2 = new ArrayList<>();
        visit(root1, res1);
        visit(root2, res2);
        if (res1.size() != res2.size()) {
            return false;
        }
        for (int i = 0; i < res1.size(); i++) {
            if (!res1.get(i).equals(res2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void visit(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        visit(root.left, list);
        visit(root.right, list);
    }
}
