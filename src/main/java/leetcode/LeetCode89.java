package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        final List<Integer> res = new ArrayList<>(1 << n);
        for (int i = 0; i < size; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
