package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        final Set<Integer> set = new HashSet<>();
        final List<Integer> res = new ArrayList<>();
        for (int[] row : matrix) {
            int min = Integer.MAX_VALUE;
            for (int i : row) {
                if (i < min) {
                    min = i;
                }
            }
            set.add(min);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > max) {
                    max = matrix[j][i];
                }
            }
            if (set.contains(max)) {
                res.add(max);
            }
        }
        return res;
    }
}
