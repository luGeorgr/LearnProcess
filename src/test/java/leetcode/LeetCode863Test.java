package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode863Test {
    private LeetCode863 leetCode863;
    private TreeNode root;
    private TreeNode target;

    @Before
    public void before() {
        leetCode863 = new LeetCode863();
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node0.left = node2;
        node0.right = node1;
        node1.left = node3;

        root = node0;
        target = node3;
    }

    @Test
    public void distanceK() {
        Assert.assertEquals(2, leetCode863.distanceK(root, target, 3).get(0).intValue());
    }
}