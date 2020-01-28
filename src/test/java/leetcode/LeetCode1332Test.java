package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1332Test {

    @Test
    public void removePalindromeSub() {
        final LeetCode1332 leetCode1332 = new LeetCode1332();
        Assert.assertEquals(2 ,leetCode1332.removePalindromeSub("baabb"));
        Assert.assertEquals(2 ,leetCode1332.removePalindromeSub("bbaabaaa"));
    }
}