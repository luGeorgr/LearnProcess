package leetcode;

public class LeetCode598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m, minCol = n;
        for (int[] op : ops) {
            minRow = op[0] < minRow ? op[0] : minRow;
            minCol = op[1] < minCol ? op[1] : minCol;
        }
        return minRow * minCol;
    }
}
