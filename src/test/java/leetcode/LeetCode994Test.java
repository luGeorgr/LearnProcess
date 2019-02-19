package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode994Test {

    @Test
    public void orangesRotting() {
        LeetCode994 leetCode994 = new LeetCode994();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        Assert.assertEquals(4, leetCode994.orangesRotting(grid));
    }
}