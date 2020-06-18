package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LeetCode1202Test {

    @Test
    public void smallestStringWithSwaps() {
        final LeetCode1202 leetCode1202 = new LeetCode1202();
        final List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>());
        pairs.add(new ArrayList<>());
        pairs.add(new ArrayList<>());
        pairs.get(0).add(0);
        pairs.get(0).add(3);
        pairs.get(1).add(1);
        pairs.get(1).add(2);
        pairs.get(2).add(0);
        pairs.get(2).add(2);
        leetCode1202.smallestStringWithSwaps("dcab", pairs);
    }
}