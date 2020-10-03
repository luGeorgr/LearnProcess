package leetcode;

public class LeetCode1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int count = 0;
        count = count + (arr[0] % 2 == 1 ? 1 : 0);
        count = count + (arr[1] % 2 == 1 ? 1 : 0);
        count = count + (arr[2] % 2 == 1 ? 1 : 0);
        if (count == 3) {
            return true;
        }
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count += 1;
            }
            if (arr[i - 3] % 2 == 1) {
                count -= 1;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
