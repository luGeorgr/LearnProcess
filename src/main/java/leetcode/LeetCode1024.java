package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1024 {
    public static void main(String[] argv) {
        int[][] clips = new int[][] {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        LeetCode1024 leetCode1024 = new LeetCode1024();
        System.out.println(leetCode1024.videoStitching(clips, 9));
    }

    public int videoStitching(int[][] clips, int T) {
        if (clips.length == 0) {
            return -1;
        }
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        int count;
        final int[][] stack = new int[clips.length][2];
        stack[0][0] = clips[0][0];
        if (stack[0][0] != 0) {
            return -1;
        }
        stack[0][1] = clips[0][1];
        count = 1;
        for (int i = 1; i < clips.length && stack[count-1][1] < T; i++) {
            if (clips[i][0] == stack[count-1][0] || clips[i][1] <= stack[count-1][1]) {
                continue;
            } else if (clips[i][0] >  stack[count-1][1]) {
                return -1;
            }
            if (count >= 2 && stack[count - 2][1] >= clips[i][0] && clips[i][1] > stack[count-1][1]) {
                stack[count-1][0] = clips[i][0];
                stack[count-1][1] = clips[i][1];
            } else {
                stack[count][0] = clips[i][0];
                stack[count][1] = clips[i][1];
                count++;
            }
        }
        return stack[count-1][1] < T ? -1 : count;
    }

}
