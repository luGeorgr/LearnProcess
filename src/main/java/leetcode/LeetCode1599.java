package leetcode;

public class LeetCode1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (4 * boardingCost <= runningCost) {
            return -1;
        }
        int maxRound = 0;
        int maxValue = 0;
        int remain = 0;
        int nowValue = 0;
        for (int i = 0; i < customers.length || remain != 0; i++) {
            remain += i < customers.length ? customers[i] : 0;
            int customer;
            if (remain <= 4) {
                customer = remain;
                remain = 0;
            } else {
                remain -= 4;
                customer = 4;
            }
            nowValue += customer * boardingCost - runningCost;
            if (nowValue > maxValue) {
                maxValue = nowValue;
                maxRound = i;
            }
        }
        return maxValue > 0 ? maxRound + 1 : -1;
    }
}
