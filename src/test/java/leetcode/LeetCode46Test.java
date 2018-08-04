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

    private LeetCode46A mLeetCode46A;
    private LeetCode46B mLeetCode46B;

    @Before
    public void before() {
        mLeetCode46A = new LeetCode46A();
        mLeetCode46B = new LeetCode46B();
    }

    @Test
    public void testPermute() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = mLeetCode46A.permute(arr);
        Assert.assertEquals(6, res.size());
        Assert.assertEquals(6, mLeetCode46B.permute(arr).size());
    }
}