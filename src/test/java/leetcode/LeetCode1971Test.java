package leetcode;

import junit.framework.TestCase;

public class LeetCode1971Test extends TestCase {

    public void testValidPath() {
        final LeetCode1971 leetCode1971 = new LeetCode1971();
        leetCode1971.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2);
    }
}