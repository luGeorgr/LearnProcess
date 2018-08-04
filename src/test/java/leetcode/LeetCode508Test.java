package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode508Test {

    @Test
    public void testFindFrequentTreeSum() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-3);
        root.left = left;
        root.right = right;

        LeetCode508 leetCode508 = new LeetCode508();
        leetCode508.findFrequentTreeSum(root);
    }
}