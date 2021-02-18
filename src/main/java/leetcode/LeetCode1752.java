package leetcode;

public class LeetCode1752 {
    public boolean check(int[] nums) {
        int min = nums[0];
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                break;
            }
        }
        if (i >= nums.length) {
            return true;
        }

        int max = nums[i++];
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
            max = nums[i];
        }

        return max <= min;
    }
}
