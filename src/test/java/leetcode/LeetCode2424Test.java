package leetcode;

import junit.framework.TestCase;

public class LeetCode2424Test extends TestCase {
    public void test() {
        final LeetCode2424.LUPrefix prefix = new LeetCode2424.LUPrefix(4);
        prefix.upload(3);
        prefix.longest();
        prefix.upload(1);
        prefix.longest();
        prefix.upload(2);
        prefix.longest();

    }
}