package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1020 {

    public static void main(String[] argv) {
        int[][] A = new int[][] {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}};
        LeetCode1020 leetCode1020 = new LeetCode1020();
        System.out.println(leetCode1020.numEnclaves(A));
    }

    public int numEnclaves(int[][] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        int totalRow = A.length;
        int totalCol = A[0].length;
        final boolean[][] visited = new boolean[totalRow][totalCol];
        for (int i = 0; i < totalCol; i++) {
            if (A[0][i] == 1 && !visited[0][i]) {
                count = bfs(totalRow, totalCol, A, visited, 0, i, count);
            }
            if (A[totalRow - 1][i] == 1 && !visited[totalRow - 1][i]) {
                count = bfs(totalRow, totalCol, A, visited, totalRow - 1, i, count);
            }
        }
        for (int i = 0; i < totalRow; i++) {
            if (A[i][0] == 1 && !visited[i][0]) {
                count = bfs(totalRow, totalCol, A, visited, i, 0, count);
            }
            if (A[i][totalCol - 1] == 1 && !visited[i][totalCol - 1]) {
                count = bfs(totalRow, totalCol, A, visited, i, totalCol - 1, count);
            }
        }
        return count;
    }

    private static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row =  row;
            this.col = col;
        }
    }

    private int bfs(int totalRow, int totalCol, int[][] A, boolean[][] visited, int row, int col, int count) {
        final Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        count--;
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            final Pair node = queue.poll();
            if (node.row  > 0 && A[node.row - 1][node.col] == 1 && !visited[node.row - 1][node.col]) {
                queue.offer(new Pair(node.row - 1, node.col));
                count--;
                visited[node.row - 1][node.col] = true;
            }
            if (node.row < totalRow - 1 && A[node.row + 1][node.col] == 1 && !visited[node.row + 1][node.col]) {
                queue.offer(new Pair(node.row + 1, node.col));
                count--;
                visited[node.row + 1][node.col] = true;
            }
            if (node.col < totalCol - 1 && A[node.row][node.col + 1] == 1 && !visited[node.row][node.col + 1]) {
                queue.offer(new Pair(node.row, node.col + 1));
                count--;
                visited[node.row][node.col + 1] = true;
            }
            if (node.col > 0 && A[node.row][node.col - 1] == 1 && !visited[node.row][node.col - 1]) {
                queue.offer(new Pair(node.row, node.col - 1));
                count--;
                visited[node.row][node.col - 1] = true;
            }
        }
        return count;
    }
}
