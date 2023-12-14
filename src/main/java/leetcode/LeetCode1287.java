package leetcode;

public class LeetCode1287 {
    public int findSpecialInteger(int[] arr) {
        int current = arr[0];
        int count = 0;
        int special = arr.length % 4 == 0 ? arr.length / 4 : arr.length / 4 + 1;
        for (int num : arr) {
            if (num == current) {
                count++;
            } else {
                current = num;
                count = 1;
            }
            if (count >= special) {
                return current;
            }
        }
        return count;
    }
}
