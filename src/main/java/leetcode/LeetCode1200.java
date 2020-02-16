package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < arr.length; i++) {
            final int difference = arr[i+1] - arr[i];
            if (difference < min) {
                res.clear();
                min = difference;
            } else if (difference > min) {
                continue;
            }
            final List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i+1]);
            res.add(list);
        }
        return res;
    }
}
