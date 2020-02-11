package leetcode;

import java.util.Arrays;

public class LeetCode1346 {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero += 1;
                continue;
            }
            if (arr[i] > max / 2) {
                break;
            } else if (Arrays.binarySearch(arr, arr[i] * 2) >= 0) {
                return true;
            }
        }
        return countZero > 1;
    }
}
