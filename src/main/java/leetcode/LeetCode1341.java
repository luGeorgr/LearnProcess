package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode1341 {
    public int[] kWeakestRows(int[][] mat, int k) {
        final int[] res = new int[k];
        final List<Node> nodes = new ArrayList<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (final int value : mat[i]) {
                if (value == 1) {
                    count++;
                }
            }
            nodes.add(new Node(i, count));
        }
        final List<Node> sorted = nodes.stream().sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            res[i] = sorted.get(i).index;
        }
        return res;
    }

    private class Node implements Comparable {
        private int index;
        private int count;
        Node(final int index, final int count) {
            this.index = index;
            this.count = count;
        }
        @Override
        public int compareTo(Object o) {
            final Node other = (Node) o;
            if (count < other.count) {
                return -1;
            } else if (count > other.count) {
                return 1;
            } else if (index < other.index) {
                return -1;
            }
            return 1;
        }
    }
}
