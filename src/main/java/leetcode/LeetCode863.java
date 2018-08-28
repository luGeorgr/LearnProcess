package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        distanceK(res, root, target, K);
        return res;
    }

    private Integer distanceK(List<Integer> res, TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return -1;
        }

        if (root == target) {
            distanceK(res, root, K);
            return K - 1;
        }

        int nextK;
        if ((nextK = distanceK(res, root.left, target, K)) >= 0) {
            if (nextK == 0) {
                res.add(root.val);
            } else {
                distanceK(res, root.right, nextK - 1);
            }
            return nextK - 1;
        }

        if ((nextK = distanceK(res, root.right, target, K)) >= 0) {
            if (nextK == 0) {
                res.add(root.val);
            } else {
                distanceK(res, root.left, nextK - 1);
            }
            return nextK - 1;
        }
        return -1;
    }

    private void distanceK(List<Integer> res, TreeNode root, int K) {
        if (root == null || K < 0) {
            return;
        }
        if (K == 0) {
            res.add(root.val);
            return;
        }
        distanceK(res, root.left, K-1);
        distanceK(res, root.right, K-1);
    }
}
