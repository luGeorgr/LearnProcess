package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1342Test {

    @Test
    public void numberOfSteps() {
        final LeetCode1342 leetCode1342 = new LeetCode1342();
        Assert.assertEquals(4, leetCode1342.numberOfSteps(8));
        Assert.assertEquals(6, leetCode1342.numberOfSteps(14));
        Assert.assertEquals(12, leetCode1342.numberOfSteps(123));
    }
}