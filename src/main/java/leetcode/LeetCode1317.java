package leetcode;

/**
 * 一开始想到的是nextNoZeroInteger, 去构造x从而加速整个算法。
 * 实现直接是按照最直接的方式实现了
 * 看了discuss觉得很有道理，可以按照拆分的方式保证两个数都为no zero
 */
public class LeetCode1317 {
    public int[] getNoZeroIntegers(int n) {
        final int[] res = new int[2];
        for (int i = 1; i < n; i++) {
            if (isNoZeroInteger(i) && isNoZeroInteger(n - i)) {
                res[0] = i;
                res[1] = n - i;
                break;
            }
         }
        return res;
    }

    private boolean isNoZeroInteger(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n = n / 10;
       }
        return true;
    }
}
