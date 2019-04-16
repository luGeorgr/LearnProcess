package leetcode;

public class LeetCode875 {
    public static void main(String[] argv) {
        LeetCode875 leetCode875 = new LeetCode875();
        int[] pipes = new int[]{980628391,681530205,734313996,168632541};
        leetCode875.minEatingSpeed(pipes, 819870953);
    }
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int i : piles) {
            if (i > max) {
                max = i;
            }
        }
        int begin = 1;
        int end = max / (H / piles.length);
        while (true) {
            int mid = (begin + end) / 2;
            if (!(begin < mid && mid < end)) {
                break;
            }
            if (judge(piles, H, mid)) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        if (judge(piles, H, begin)) {
            return begin;
        } else if (judge(piles, H ,(end + begin) / 2)) {
            return (end + begin) / 2;
        } else {
            return end;
        }
    }

    private boolean judge(int[] pipes, int H, int K) {
        int sum = 0;
        for (int i : pipes) {
            sum += i / K;
            sum = (i % K == 0) ? sum : sum + 1;
        }
        return sum <= H;
    }
}
