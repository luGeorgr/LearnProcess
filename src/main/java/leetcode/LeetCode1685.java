package leetcode;

public class LeetCode1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] res = new int[nums.length];
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = sum - leftSum - nums[i];
            res[i] = nums[i] * i - leftSum + rightSum - (nums[i] * (nums.length - i - 1));
            leftSum = leftSum + nums[i];
        }
        return res;
    }
}
