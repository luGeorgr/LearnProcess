package leetcode;

public class LeetCode565 {

    public int arrayNesting(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        boolean[] flags = new boolean[nums.length];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = false;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && flags[j]) {
                j++;
            }

            if (j >= nums.length) {
                break;
            }
            flags[j] = true;
            int now = 1;
            for (j = nums[j]; !flags[j];) {
                now++;
                j = nums[j];
            }

            if (now > max) {
                max = now;
            }
        }

        return max;
    }
}