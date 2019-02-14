package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode991Test {

    private static final LeetCode991 solution = new LeetCode991();
    @Test
    public void brokenCalc() {
        Assert.assertEquals(2, solution.brokenCalc(5, 8));
        Assert.assertEquals(2, solution.brokenCalc(2, 3));
    }
}