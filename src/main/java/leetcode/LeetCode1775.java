package leetcode;

public class LeetCode1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums1.length * 6 < nums2.length ) {
            return -1;
        }
        int[] count1 = new int[]{0,0,0,0,0,0};
        int[] count2 = new int[]{0,0,0,0,0,0};
        int sum1 = 0;
        int sum2 = 0;
        for (int i : nums1) {
            count1[i-1]++;
            sum1 += i;
        }
        for (int i : nums2) {
            count2[i-1]++;
            sum2 += i;
        }
        if (sum1 > sum2) {
            return minOperations(sum1 - sum2, sum(count2, count1));
        } else {
            return minOperations(sum2 - sum1, sum(count1, count2));
        }
    }

    private int[] sum(int[] count1, int[] count2) {
        int[] ans = new int[count1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = count1[i] + count2[ans.length - i - 1];
        }
        return ans;
    }

    private int minOperations(int sub, int[] count) {
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (sub > (5 - i) * count[i]) {
                sub -= (5 - i) * count[i];
                ans += count[i];
            } else {
                ans += sub / (5 - i) + ((sub % (5 - i) != 0) ? 1 : 0);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        final LeetCode1775 leetCode1775 = new LeetCode1775();
        leetCode1775.minOperations(new int[]{5,6,4,3,1,2}, new int[]
                {6,3,3,1,4,5,3,4,1,3,4});
    }
}
