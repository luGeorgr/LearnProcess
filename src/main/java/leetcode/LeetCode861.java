package leetcode;

public class LeetCode861 {
    public int matrixScore(int[][] A) {
        int rowNumber = A.length;
        int colNumber = A[0].length;
        for (int[] row : A) {
            if (row[0] != 1) {
                flipOneRow(row);
            }
        }

        for (int j = 1; j < colNumber; j++) {
            int zeroCount = 0;
            for (int i = 0; i < rowNumber; i++) {
                if (A[i][j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount * 2 > rowNumber) {
                for (int i = 0; i < rowNumber; i++) {
                    A[i][j] = (A[i][j] == 0) ? 1 : 0;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < rowNumber; i++) {
            int temp = 0;
            for (int j = 0; j < colNumber; j++) {
                temp += A[i][j];
                temp = temp * 2;
            }
            sum += temp / 2;
        }
        return sum;
    }

    private void flipOneRow(int[] row) {
        for (int i = 0; i < row.length; i ++) {
            row[i] = (row[i] == 0) ? 1 : 0;
        }
    }
}
