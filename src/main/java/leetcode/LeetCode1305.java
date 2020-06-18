package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final List<Integer> list1 = new ArrayList<>();
        final List<Integer> list2 = new ArrayList<>();
        visit(list1, root1);
        visit(list2, root2);
        final List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        for (int k = 0; k < list1.size() + list2.size(); k++) {
            if (i < list1.size() && j < list2.size()) {
                if (list1.get(i) < list2.get(j)) {
                    res.add(list1.get(i++));
                } else {
                    res.add(list2.get(j++));
                }
            } else if (i < list1.size()) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        return res;
    }

    private void visit(final List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        visit(list, root.left);
        list.add(root.val);
        visit(list, root.right);
    }
}
