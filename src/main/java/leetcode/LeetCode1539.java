package leetcode;

public class LeetCode1539 {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int start = 1;
        for (final int num : arr) {
            int step = 0;
            if (num > start) {
                step = num - start;
            }
            if (count + step >= k) {
                break;
            }
            count += step;
            start = num + 1;
        }
        return start + k - count - 1;
    }
}
