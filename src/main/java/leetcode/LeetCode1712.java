package leetcode;

public class LeetCode1712 {
    public int waysToSplit(int[] nums) {
        int[] sum = new int[nums.length];
        int nowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            nowSum += nums[i];
            sum[i] = nowSum;
        }

        int result = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums.length - 2 && sum[i] <= sum[nums.length - 1] / 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int mid = (left + right) / 2;
                if (sum[mid] >= 2 * sum[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int j1 = left;
            right = nums.length - 1;
            left = i;
            while (right > left) {
                int mid = (left + right) / 2;
                if (sum[nums.length - 1] + sum[i] >= 2 * sum[mid]) {
                    if (left != mid) {
                        left = mid;
                    } else if (sum[nums.length - 1] + sum[i] >= 2 * sum[right]) {
                        left = right;
                    } else {
                        right = left;
                    }
                } else {
                    right = mid - 1;
                }
            }
            int j2 = left == nums.length - 1 ? left - 1 : left;
            result = (result + Math.max(j2 - j1 + 1, 0)) % mod;
        }
        return result;
    }
}
