package leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  注意利用矩阵对角线性质， 对角线上的 （i - j）是可以作为分组依据的。
 */
public class LeetCode1329 {
    public int[][] diagonalSort(int[][] mat) {
        Deque<List<Integer>> stack = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            if (i == 0) {
                for (int j = 0; j < mat[0].length; j++) {
                    stack.addFirst(new LinkedList<>());
                }
            } else {
                stack.addFirst(new LinkedList<>());
            }
            int j = 0;
            for (List<Integer> list : stack) {
                list.add(0, mat[i][j++]);
                if (j >= mat[i].length) {
                    break;
                }
            }
        }
        stack.forEach(list -> list.sort(Comparator.comparing(val -> -val)));
        for (int i = mat.length - 1; i >= 0; i--) {
            int j = 0;
            for (final List<Integer> list : stack) {
                mat[i][j++] = list.get(0);
                list.remove(0);
                if (j >= mat[i].length) {
                    break;
                }
            }
            stack.pop();
        }
        return mat;
    }
}
