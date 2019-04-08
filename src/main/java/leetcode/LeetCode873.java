package leetcode;

import java.util.HashSet;

public class LeetCode873 {
    public int lenLongestFibSubseq(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int temp = 0;
                int a = A[i], b = A[j];
                while (set.contains(a + b)) {
                    int c = a;
                    a = b;
                    b += c;
                    temp += 1;
                }
                if (temp != 0 && temp + 2 > max) {
                    max = temp + 2;
                }
            }
        }
        return max;
    }
}
