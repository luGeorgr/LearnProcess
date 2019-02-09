package leetcode;

public class LeetCode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int begin = 0, end, max = 0;
        do {
            while (begin < nums.length && nums[begin] == 0) {
                begin++;
            }
            end = begin;
            while (end < nums.length && nums[end] == 1) {
                end++;
            }
            if (end - begin > max) {
                max = end - begin;
            }
            if (end >= nums.length) {
                break;
            }
            begin = end;
        } while (true);
        return max;
    }
}
