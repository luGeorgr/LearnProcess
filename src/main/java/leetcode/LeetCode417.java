package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        Status[][] pacific = new Status[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = new Status(true, heights[i][j]);
                    continue;
                }
                boolean status = (pacific[i-1][j].status && pacific[i-1][j].height <= heights[i][j])
                        || (pacific[i][j-1].status && pacific[i][j-1].height <= heights[i][j]);
                int height = status ? heights[i][j] : Math.min(pacific[i][j-1].height, pacific[i-1][j].height);
                pacific[i][j] = new Status(status, height);
            }
        }
        Status[][] atlantic = new Status[row][col];
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 || j == col - 1) {
                    atlantic[i][j] = new Status(true, heights[i][j]);
                } else {
                    boolean status = (atlantic[i + 1][j].status && atlantic[i + 1][j].height <= heights[i][j])
                            || (atlantic[i][j + 1].status && atlantic[i][j + 1].height <= heights[i][j]);
                    int height = status ? heights[i][j] : Math.min(atlantic[i][j + 1].height, atlantic[i + 1][j].height);
                    atlantic[i][j] = new Status(status, height);
                }
                pacific[i][j].status = pacific[i][j].status
                        || (i != row - 1 && pacific[i + 1][j].status && heights[i][j] >= heights[i+1][j])
                        || (j != col - 1 && pacific[i][j + 1].status && heights[i][j] >= heights[i][j+1]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                atlantic[i][j].status = atlantic[i][j].status
                        || (i != 0 && atlantic[i - 1][j].status && heights[i][j] >= heights[i-1][j])
                        || (j != 0 && atlantic[i][j - 1].status && heights[i][j] >= heights[i][j - 1]);
                if (atlantic[i][j].status && pacific[i][j].status) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    res.add(pair);
                }
            }
        }
        return res;
    }

    private class Status {
        Status(boolean status, int height) {
            this.status = status;
            this.height = height;
        }

        boolean status;

        int height;
    }
}
