package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1343Test {

    @Test
    public void numOfSubarrays() {
        final LeetCode1343 leetCode1343 = new LeetCode1343();
        Assert.assertEquals(3, leetCode1343.numOfSubarrays(new int[] {2,2,2,2,5,5,5,8}, 3, 4));
    }
}