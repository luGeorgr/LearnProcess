package leetcode;

import java.util.Arrays;

public class LeetCode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] root = new int[n];
        Arrays.fill(root, -1);
        for (int[] edge : edges) {
            int iRoot = findRoot(root, edge[0]);
            int jRoot = findRoot(root, edge[1]);
            if (iRoot != jRoot) {
                root[iRoot] = jRoot;
            }
        }
        return findRoot(root, source) == findRoot(root, destination);
    }

    private int findRoot(int[] root, int index) {
        if (root[index] == -1) {
            return index;
        }
        root[index] = findRoot(root, root[index]);
        return root[index];
    }


}
