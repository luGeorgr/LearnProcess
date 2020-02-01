package leetcode;

public class LeetCode1318 {
    public int minFlips(int a, int b, int c) {
        if (a < b) {
            int temp =  a;
            a = b;
            b = temp;
        }
        int count = 0;
        while (b != 0) {
            int aa = a & 1;
            int bb = b & 1;
            int cc = c & 1;
            a >>= 1;
            b >>= 1;
            c >>= 1;
            if ((aa | bb) != cc) {
                if (cc == 0) {
                    count += aa + bb;
                } else {
                    count += 1;
                }
            }
        }
        while (a != 0) {
            int aa = a & 1;
            int cc = c & 1;
            a >>= 1;
            c >>= 1;
            if (aa != cc) {
                count += 1;
            }
        }
        while (c != 0) {
            int cc = c & 1;
            c >>=1;
            count += cc;
        }
        return count;
    }
}
