package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sum += A[i];
            }
        }

        int i = 0;
        for (final int[] query : queries) {
            if (A[query[1]] % 2 == 0) {
                if (query[0] % 2 == 0) {
                    sum += query[0];
                } else {
                    sum -= A[query[1]];
                }
            } else if (query[0] % 2 != 0) {
                sum += A[query[1]] + query[0];
            }
            A[query[1]] += query[0];
            res[i++] = sum;
        }
        return res;
    }
}
