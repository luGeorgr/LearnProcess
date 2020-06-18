package leetcode;

import java.util.Arrays;

public class LeetCode1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        final int[] results = new int[n];
        Arrays.fill(results, -1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = fill(results, manager, informTime, headID, i);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    private int fill(int[] results, int[] manager, int[] informTime, int headID, int index) {
        if (index == headID) {
            results[index] = 0;
            return 0;
        }
        if (results[index] != -1) {
            return results[index];
        }
        results[index] = fill(results, manager, informTime, headID, manager[index]) + informTime[manager[index]];
        return results[index];
    }
}
