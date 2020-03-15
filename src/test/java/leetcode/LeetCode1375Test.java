package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1375Test {

    @Test
    public void numTimesAllBlue() {
        final LeetCode1375 leetCode1375 = new LeetCode1375();
        Assert.assertEquals(3, leetCode1375.numTimesAllBlue(new int[]{2,1,3,5,4}));
    }
}