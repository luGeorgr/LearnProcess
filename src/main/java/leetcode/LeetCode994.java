package leetcode;

public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean changed;
        int count = -1;
        int val = 2;
        do {
            count++;
            changed = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == val) {
                        if (grid[i > 0 ? i - 1 : i][j] == 1) {
                            grid[i-1][j] = val + 1;
                            changed = true;
                        }

                        if (grid[i + 1 < row ? i + 1 : i][j] == 1) {
                            grid[i+1][j] = val + 1;
                            changed = true;
                        }

                        if (grid[i][j > 0 ? j - 1 : j] == 1) {
                            grid[i][j-1] = val + 1;
                            changed = true;
                        }

                        if (grid[i][j + 1 < col ? j + 1 : j] == 1) {
                            grid[i][j+1] = val + 1;
                            changed = true;
                        }
                    }
                }
            }
            val++;
        } while (changed);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
