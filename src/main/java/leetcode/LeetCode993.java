package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.offer(root);
        boolean find = false;
        do {
            while (!current.isEmpty()) {
                final TreeNode node = current.poll();
                boolean flag = false;
                if (node.left != null && (node.left.val == x || node.left.val == y)) {
                    if (find) {
                        return true;
                    }
                    find = true;
                    flag = true;
                } else if (node.left != null){
                    next.offer(node.left);
                }

                if (node.right != null && (node.right.val == x || node.right.val == y)) {
                    if (flag) {
                        return false;
                    }
                    if (find) {
                        return true;
                    }
                    find = true;
                } else if (node.right != null) {
                    next.offer(node.right);
                }
            }
            Queue<TreeNode> temp = current; current = next; next = temp;
            if (find) {
                return false;
            }
        } while (!current.isEmpty());
        return false;
    }
}
