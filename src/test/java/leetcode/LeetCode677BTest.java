package leetcode;

import org.junit.Before;
import org.junit.Test;

public class LeetCode677BTest {
    LeetCode677B leetCode677B;
    @Before
    public void before() {
        leetCode677B = new LeetCode677B();
    }

    @Test
    public void insert() {
        leetCode677B.insert("app", 3);
        leetCode677B.insert("app", 2);
    }

    @Test
    public void sum() {
    }
}