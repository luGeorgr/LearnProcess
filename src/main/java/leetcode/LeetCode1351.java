package leetcode;

public class LeetCode1351 {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return countNegatives(grid, 0, row, 0, col);
    }

    private int countNegatives(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
        if (startRow == endRow || startCol == endCol) {
            return 0;
        }
        if (startRow + 1 == endRow && startCol + 1 == endCol) {
            if (grid[startRow][startCol] < 0) {
                return 1;
            }
            return 0;
        }
        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;
        if (grid[midRow][midCol] < 0) {
            return (endRow - midRow) * (endCol - midCol)
                    + countNegatives(grid, startRow, midRow, startCol, midCol)
                    + countNegatives(grid, startRow, midRow, midCol, endCol)
                    + countNegatives(grid, midRow, endRow, startCol, midCol);
        }
        int left = countNegatives(grid, midRow + 1, endRow, startCol, midCol + 1);
        int top = countNegatives(grid, startRow, midRow + 1, midCol + 1, endCol);
        return left + top + countNegatives(grid, midRow + 1, endRow, midCol + 1, endCol);
    }
}
