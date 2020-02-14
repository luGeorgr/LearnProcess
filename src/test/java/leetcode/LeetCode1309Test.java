package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1309Test {

    @Test
    public void freqAlphabets() {
        final LeetCode1309 leetCode1309 = new LeetCode1309();
        Assert.assertEquals("jkab", leetCode1309.freqAlphabets("10#11#12"));
    }
}