package leetcode;

public class LeetCode556 {
    public int nextGreaterElement(int n) {
        final int[] list = new int[32];
        int cur = 0;
        int i = 0;
        while(n != 0) {
            int temp = n % 10;
            if (cur > temp) {
                break;
            } else {
                cur = list[i++] = temp;
                n /= 10;
            }
        }
        if (n == 0) {
            return -1;
        }

        int temp = n % 10;
        for (int j = 0; j < i; j++) {
            if (list[j] > temp) {
                n = n / 10 * 10 + list[j];
                list[j] = temp;
                break;
            }
        }

        for (int j = 0; j < i; j++) {
            if (n > n * 10 + list[j]) {
                return -1;
            }
            n = n * 10 + list[j];
        }
        return n;
    }
}
