package leetcode;

public class LeetCode453 {
    public int minMoves(int[] nums) {
        int sum = 0;
        int size = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return sum - size * min;
    }
}
