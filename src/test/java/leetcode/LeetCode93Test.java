package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeetCode93Test {

    @Test
    public void restoreIpAddresses() {
        final LeetCode93 leetCode93 = new LeetCode93();
        List<String> res = leetCode93.restoreIpAddresses("0001");
        Assert.assertEquals(res.get(0), "0.0.0.1");
        res = leetCode93.restoreIpAddresses("25525511135");
        Assert.assertEquals("255.255.11.135", res.get(0));
        Assert.assertEquals("255.255.111.35", res.get(1));
    }
}