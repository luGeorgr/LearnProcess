package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode886Test {

    @Test
    public void possibleBipartition() {
        LeetCode886 leetCode886 = new LeetCode886();
        int[][] dislike =
                {{2,7},{4,10},{4,7},{1,3},{4,9},{4,6},{2,9},{4,8},{4,5},{2,8},{2,10},{1,5},{1,8},{2,6},{1,6},{1,9},{1,7},{1,10},{2,3},{2,5},{3,4}};
        Assert.assertTrue(leetCode886.possibleBipartition(10, dislike));
    }
}