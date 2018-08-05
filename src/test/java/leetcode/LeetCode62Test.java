package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode62Test {

    @Test
    public void testUniquePaths() {
        LeetCode62 leetCode62 = new LeetCode62();
        Assert.assertEquals(28, leetCode62.uniquePaths(7,3));
    }
}