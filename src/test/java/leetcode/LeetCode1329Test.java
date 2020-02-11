package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1329Test {

    @Test
    public void diagonalSort() {
        final LeetCode1329 leetCode1329 = new LeetCode1329();
        int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        leetCode1329.diagonalSort(mat);
    }
}