package leetcode;

public class LeetCode999 {
    public int numRookCaptures(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int col = 0, row = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'B') {
                break;
            } else if (board[i][col] == 'p') {
                count += 1;
                break;
            }
        }

        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == 'B') {
                break;
            } else if (board[i][col] == 'p') {
                count += 1;
                break;
            }
        }

        for (int j = col - 1; j >= 0; j--) {
            if (board[row][j] == 'B') {
                break;
            } else if (board[row][j] == 'p') {
                count += 1;
                break;
            }
        }

        for (int j = col + 1; j < board[0].length; j++) {
            if (board[row][j] == 'B') {
                break;
            } else if (board[row][j] == 'p') {
                count += 1;
                break;
            }
        }
        return count;
    }
}
