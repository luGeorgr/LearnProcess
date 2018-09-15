package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }
        final int[] parent = new int[N+1];
        final Map<Integer, Integer> conflictMap = new HashMap<>();
        parent[dislikes[0][0]] = dislikes[0][0];
        parent[dislikes[0][1]] = dislikes[0][1];
        conflictMap.put(dislikes[0][0], dislikes[0][1]);
        conflictMap.put(dislikes[0][1], dislikes[0][0]);
        for (int i = 1; i < dislikes.length; i++) {
            int parentA = find(parent, dislikes[i][0]), parentB = find(parent, dislikes[i][1]);
            if (parentA != 0 && parentB != 0) {
                if (parentA == parentB) {
                    return false;
                } else if (conflictMap.size() > 2 && conflictMap.get(parentA) != parentB) {
                    parent[conflictMap.get(parentB)] = parentA;
                    parent[parentB] = conflictMap.get(parentA);
                    conflictMap.remove(conflictMap.get(parentB));
                    conflictMap.remove(parentB);
                }
            } else if (parentA != 0) {
                parent[dislikes[i][1]] = conflictMap.get(parentA);
            } else if (parentB != 0) {
                parent[dislikes[i][0]] = conflictMap.get(parentB);
            } else {
                parent[dislikes[i][0]] = dislikes[i][0];
                parent[dislikes[i][1]] = dislikes[i][1];
                conflictMap.put( dislikes[i][0], dislikes[i][1]);
                conflictMap.put(dislikes[i][1],  dislikes[i][0]);
            }
        }
        return true;
    }

    private int find(final int[] parent, int pos) {
        if (parent[pos] == pos) {
            return pos;
        }
        return parent[pos] = find(parent, parent[pos]);
    }
}
