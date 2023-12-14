package leetcode;

import java.util.Arrays;

public class LeetCode1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int max = 0;
        for (int i = 0, j = piles.length - 2; i < piles.length / 3; i++, j -= 2) {
            max += piles[j];
        }
        return max;
    }
}
