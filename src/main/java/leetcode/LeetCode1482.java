package leetcode;

public class LeetCode1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int res = -1;
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int day : bloomDay) {
            l = Math.min(l, day);
            r = Math.max(r, day);
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = counted(bloomDay, mid, k);
            if (count < m) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    private int counted(int[] bloomDay, int mid, int k) {
        int res = 0;
        int count = 0;
        for (int day : bloomDay) {
            if (day > mid) {
                res += count / k;
                count = 0;
            } else {
                count++;
            }
        }
        res += count / k;
        return res;
    }
}
