package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1319Test {

    @Test
    public void makeConnected() {
        final LeetCode1319 leetCode1319 = new LeetCode1319();
        int[][] connections = new int[][] {
                {1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}
        };
        Assert.assertEquals(3, leetCode1319.makeConnected(11, connections));
    }
}