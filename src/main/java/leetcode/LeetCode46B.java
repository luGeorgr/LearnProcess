package leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

/*
** use backtrack
 */
public class LeetCode46B {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] flags = new boolean[nums.length];
        for (boolean flag : flags) {
            flag = false;
        }
        backtrace(res, path, nums, flags);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] flags) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                path.add(nums[i]);
                flags[i] = true;
                backtrace(res, path, nums, flags);
                path.remove((Integer) nums[i]);
                flags[i] = false;
            }
        }
    }
}
