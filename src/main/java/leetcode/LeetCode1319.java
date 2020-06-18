package leetcode;

public class LeetCode1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        final int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] =  -1;
        }
        for (final int[] connection : connections) {
            int root0 = findRoot(root, connection[0]);
            int root1 = findRoot(root, connection[1]);
            if (root0 != root1) {
                //合并两个集合
                if (root0 < root1) {
                    root[root1] = root0;
                } else {
                    root[root0] = root1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (root[i] == -1) {
                count++;
            }
        }
        return count - 1;
    }

    private int findRoot(final int[] root, final int index) {
        if (root[index] == -1) {
            return index;
        } else {
            int rootIndex = findRoot(root, root[index]);
            root[index] = rootIndex;
            return rootIndex;
        }
    }
}
