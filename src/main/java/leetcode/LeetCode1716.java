package leetcode;

public class LeetCode1716 {
    public int totalMoney(int n) {
        int week = n / 7;
        int day = n % 7;
        return 28 * week + week * (week - 1) * 7 / 2 + (1 + week + week + day) * day / 2;
    }
}
