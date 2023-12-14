package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {
    private List<List<String>> res = new ArrayList<>();
    boolean[][] ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new boolean[n][n];
        visit( 0,  n);
        return res;
    }

    private void visit( int row, int n) {
        if (row >= n) {
            dump();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(row, i, n)) {
                ans[row][i] = true;
                visit(row + 1, n);
                ans[row][i] = false;
            }
        }
    }

    private void dump() {
        List<String> ss = new ArrayList<>();
        for (boolean[] an : ans) {
            StringBuilder builder = new StringBuilder();
            for (boolean a : an) {
                if (a) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            ss.add(builder.toString());
        }
        res.add(ss);
    }

    private boolean check(int row, int col, int n) {
        for (int i = row - 1; i >= 0; i--) {
            if (ans[i][col]) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (ans[i][j]) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (ans[i][j]) {
                return false;
            }
        }
        return true;
    }
}
