package leetcode;

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
        leetCode165.compareVersion("1", "1.1");
    }
}