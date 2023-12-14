package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode501 {
    List<Integer> res = new ArrayList<>();
    int max = 0;
    int nowValue = Integer.MIN_VALUE;
    int nowCount = -1;

    public int[] findMode(TreeNode root) {
        inorder(root);
        check();
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (nowValue == root.val) {
            nowCount += 1;
        } else {
            check();
            nowValue = root.val;
            nowCount = 1;
        }
        inorder(root.right);
    }

    private void check() {
        if (max < nowCount) {
            max = nowCount;
            res.clear();
            res.add(nowValue);
        } else if (max == nowCount) {
            res.add(nowValue);
        }
    }
}
