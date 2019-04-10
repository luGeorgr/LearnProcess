package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode869 {
    public boolean reorderedPowerOf2(int N) {
        if (N == 0) {
            return false;
        }
        int n = N;
        int upBound = 1;
        while (n != 0) {
            n /= 10;
            upBound *= 10;
        }
        int lowBound = upBound / 10;
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        while (ans < upBound) {
            if (ans >= lowBound) {
                list.add(ans);
            }
            ans *= 2;
        }
        for (int i : list) {
            if (check(N, i)) {
                return true;
            }
        }
        return false;
    }
    private boolean check(int a, int b) {
        int[] check = new int[10];
        while (a != 0) {
            check[a % 10]++;
            a /= 10;
        }
        while (b != 0) {
            check[b % 10]--;
            b /= 10;
        }
        for (int i : check) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
