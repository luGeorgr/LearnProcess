package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        final List<Integer> res = new ArrayList<>();
        int temp = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            res.add(nums[i]);
            temp += nums[i];
            if (temp * 2 > sum) {
                break;
            }
        }
        return res;
    }
}
