package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rouqiu
 *
 */
public class LeetCode802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        final Map<Integer, Set<Integer>> in = new HashMap<>();
        final Map<Integer, Set<Integer>> out = new HashMap<>();
        final Set<Integer> results = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                final Set<Integer> set = out.getOrDefault(i, new HashSet<>());
                set.add(j);
                out.put(i, set);
            }
        }
    }
}
