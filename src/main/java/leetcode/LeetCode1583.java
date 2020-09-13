package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        int[][] scores = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[0].length; j++) {
                scores[i][preferences[i][j]] = n - j;
            }
        }

        int result = 0;
        for (int x = 0; x < n; x++) {
            int y = map.get(x);
            for (int u : preferences[x]) {
                if (u == y) {
                    break;
                }
                int v = map.get(u);
                if (scores[u][x] > scores[u][v]) {
                    result += 1;
                    break;
                }
            }
        }
        return result;
    }
}
