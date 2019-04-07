package leetcode;

public class LeetCode1009 {
    public static void main(String[] argv) {
        LeetCode1009 leetCode1009 = new LeetCode1009();
        System.out.println(leetCode1009.bitwiseComplement(1));
    }

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int count = 0;
        int n = N;
        while (n != 0) {
            count++;
            n /= 2;
        }
        return N ^ (~(0xFFFFFFFF <<  count));
    }
}
