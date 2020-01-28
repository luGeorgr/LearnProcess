package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1331 {
    public int[] arrayRankTransform(int[] arr) {
        final int[] sorted = arr.clone();
        final int[] res = new int[arr.length];
        Arrays.sort(sorted);
        final Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
