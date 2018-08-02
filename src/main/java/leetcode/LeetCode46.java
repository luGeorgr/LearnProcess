package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rouqiu
 *
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new ArrayList<>(nums.length);
        for (int i : nums) {
            cur.add(i);
        }

        do {
            res.add(cur);
            cur = next(cur);
        } while (cur != null);
        return res;
    }

    private List<Integer> next(final List<Integer> cur) {
        List<Integer> res = new ArrayList<>(cur.size());
        for (int i = cur.size() - 2, j = i + 1; i >= 0; i--, j--) {
            if (cur.get(i) < cur.get(j)) {
                int k = cur.size() - 1;
                while (cur.get(k) < cur.get(i)) {
                    k--;
                }
                res.addAll(cur.subList(0, i));
                res.add(cur.get(k));
                for (int m = cur.size() - 1; m > k; m--) {
                    res.add(cur.get(m));
                }
                res.add(cur.get(i));
                for (int m = k - 1; m > i; m--) {
                    res.add(cur.get(m));
                }
                return res;
            }
        }
        return null;
    }
}