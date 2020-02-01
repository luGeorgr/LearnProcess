package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1318Test {

    @Test
    public void minFlips() {
        final LeetCode1318 leetCode1318 = new LeetCode1318();
        Assert.assertEquals(3, leetCode1318.minFlips(2,6,5));
    }
}