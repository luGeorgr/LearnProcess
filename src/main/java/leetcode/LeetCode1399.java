package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode1399 {
    public int countLargestGroup(int n) {
        final ArrayList<Integer> cnt = new ArrayList<>(Collections.nCopies(37, 0));
        for (int i = 1; i <= n; i++) {
            int c = dsum(i);
            cnt.set(c, cnt.get(c) + 1);
        }
        return Collections.frequency(cnt, Collections.max(cnt));
    }

    private int dsum(final int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 10) + dsum(num / 10);
    }
}
