package leetcode;

import java.util.Arrays;

public class LeetCode2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000;
        while (left < right) {
            int mid = (left + right) / 2, sum = 0;
            for (int a : quantities)
                sum += (a + mid - 1) / mid;
            if (sum > n)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
