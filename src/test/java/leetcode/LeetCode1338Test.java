package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1338Test {

    @Test
    public void minSetSize() {
        final LeetCode1338 leetCode1338 = new LeetCode1338();
        Assert.assertEquals(2, leetCode1338.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }
}