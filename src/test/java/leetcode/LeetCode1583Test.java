package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1583Test {

    @Test
    public void unhappyFriends() {
        final LeetCode1583 leetCode1583 = new LeetCode1583();
        leetCode1583.unhappyFriends(4, new int[][]{{1,2,3},{3,2,0},{3,1,0},{1,2,0}}, new int[][]{{0,1},{2,3}});
    }
}