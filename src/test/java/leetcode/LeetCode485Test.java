package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode485Test {

    @Test
    public void findMaxConsecutiveOnes() {
        int[] input = new int[]{1,1,0,1,1,1};
        Assert.assertEquals(3, new LeetCode485().findMaxConsecutiveOnes(input));
    }
}