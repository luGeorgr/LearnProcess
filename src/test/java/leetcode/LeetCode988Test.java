package leetcode;

import junit.framework.TestCase;

public class LeetCode988Test extends TestCase {
    public void test() {
        final LeetCode988 leetCode988 = new LeetCode988();
        final TreeNode a = new TreeNode(25);
        final TreeNode b = new TreeNode(1);
        final TreeNode c = new TreeNode(0);
        final TreeNode d = new TreeNode(0);
        final TreeNode e = new TreeNode(1);
        final TreeNode f = new TreeNode(0);
        a.left = b;
        b.left = c;
        b.right = d;
        c.left = e;
        e.left = f;
        System.out.println(leetCode988.smallestFromLeaf(a));
    }
}