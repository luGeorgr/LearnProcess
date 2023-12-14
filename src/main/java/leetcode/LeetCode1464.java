package leetcode;

import java.util.Arrays;

public class LeetCode1464 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2];
    }
}
