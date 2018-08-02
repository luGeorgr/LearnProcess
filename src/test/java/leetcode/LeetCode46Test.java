package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author rouqiu
 *
 */
public class LeetCode46Test {

    private LeetCode46 mLeetCode46;

    @Before
    public void before() {
        mLeetCode46 = new LeetCode46();
    }

    @Test
    public void testPermute() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = mLeetCode46.permute(arr);
        Assert.assertEquals(6, res.size());
    }
}