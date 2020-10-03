package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int end = rounds[rounds.length - 1];
        int begin = rounds[0];
        final List<Integer> results = new ArrayList<>();
        if (begin < end) {
            for (int i = begin; i <= end; i++) {
                results.add(i);
            }
        } else if (begin > end) {
            for (int i = begin; i <= end + n; i++) {
                results.add(((i - 1) % n) + 1);
            }
        } else {
            results.add(begin);
        }
        return results.stream().sorted(Comparator.comparingInt(i -> i)).collect(Collectors.toList());
    }
}
