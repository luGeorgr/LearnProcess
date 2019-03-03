package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1004Test {

    @Test
    public void longestOnes() {
        int[] A = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        LeetCode1004 leetCode1004 = new LeetCode1004();
        Assert.assertEquals(10, leetCode1004.longestOnes(A, 3));
    }
}