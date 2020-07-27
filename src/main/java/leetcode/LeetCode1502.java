package leetcode;

import java.util.Arrays;

public class LeetCode1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr.length <= 2) {
            return true;
        }

        int step = arr[1] - arr[0];

        for (int i = 1; i + 1 < arr.length; i++) {
            if (arr[i+1] - arr[i] != step) {
                return false;
            }
        }
        return true;
    }
}
