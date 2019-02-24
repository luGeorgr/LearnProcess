package leetcode;

public class LeetCode997 {
    public int findJudge(int N, int[][] trust) {
        int[] counts = new int[N];
        boolean[] flags = new boolean[N];
        for (int[] t : trust) {
            counts[t[1] - 1] += 1;
            flags[t[0] - 1] = true;
        }
        for (int i = 0; i < N; i++) {
            if (counts[i] == N - 1 && !flags[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}
