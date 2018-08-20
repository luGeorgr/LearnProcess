package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode165Test {
    private LeetCode165 leetCode165;
    @Before
    public void before() {
        leetCode165 = new LeetCode165();
    }
    @Test
    public void compareVersion() {
        Assert.assertEquals(-1, leetCode165.compareVersion("1", "1.1"));
        Assert.assertEquals(0, leetCode165.compareVersion("1.0", "1.00.00"));
    }
}