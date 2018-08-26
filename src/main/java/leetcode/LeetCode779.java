package leetcode;

import java.util.ArrayList;

public class LeetCode779 {
    private int action(int num, int mode) {
        return num ^ mode;
    }

    public int kthGrammar(int N, int K) {
        ArrayList<Integer> list = new ArrayList<>(N);
        for (int i = 0, temp = K; i < N; i++, temp = (temp + 1) >> 1) {
            list.add((temp + 1) & 0x1);
        }
        int res = 0;
        for (int i = N-1; i >= 0; i--) {
            res = action(res, list.get(i));
        }
        return res;
    }
}
