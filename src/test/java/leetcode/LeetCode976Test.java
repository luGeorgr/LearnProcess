package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode976Test {

    @Test
    public void largestPerimeter() {
        LeetCode976 leetCode976 = new LeetCode976();
        Assert.assertEquals(5, leetCode976.largestPerimeter(new int[] {2,1,2}));
    }
}