package leetcode;

public class LeetCode1226 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int x = points[0][0];
        int y = points[0][1];
        for (int[] point : points) {
            res += Math.max(Math.abs(x - point[0]), Math.abs(y - point[1]));
            x = point[0];
            y = point[1];
        }
        return res;
    }
}
