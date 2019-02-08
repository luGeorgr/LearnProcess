package leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeetCode127Test {

    @Test
    public void ladderLength() {
        LeetCode127 leetCode127 = new LeetCode127();
        List<String> list = Lists.newArrayList("hot","dot","dog","lot","log","cog");
        Assert.assertEquals(5,leetCode127.ladderLength("hit", "cog", list));
    }
}