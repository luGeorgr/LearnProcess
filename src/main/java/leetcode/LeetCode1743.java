package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (final int[] pair : adjacentPairs) {
            for (int i = 0; i <= 1; i++) {
                if (!map.containsKey(pair[i])) {
                    map.put(pair[i], new ArrayList<>());
                }
                map.get(pair[i]).add(pair[i ^ 1]);
            }
        }

        int[] result = new int[adjacentPairs.length + 1];
        int now = 0;
        for (final int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                now = key;
                break;
            }
        }

        result[0] = now;
        result[1] = map.get(now).get(0);
        now = result[1];
        for (int i = 2; i < adjacentPairs.length + 1; i++) {
            for (final int j : map.get(now)) {
                if (j != result[i - 2]) {
                    now = j;
                    break;
                }
            }
            result[i] = now;
        }
        return result;
    }
}
