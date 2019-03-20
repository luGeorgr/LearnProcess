package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode332Test {

    @Test
    public void findItinerary() {
        String[][] tickets = new String[][] {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        LeetCode332 leetCode332 = new LeetCode332();
        leetCode332.findItinerary(tickets);
    }
}