package leetcode;

public class LeetCode1578 {
    public int minCost(String s, int[] cost) {
        int result = 0;
        int max = cost[0];
        int before = s.charAt(0);
        int now = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == before) {
                if (max < cost[i]) {
                    now += max;
                    max = cost[i];
                } else {
                    now += cost[i];
                }
            } else {
                before = s.charAt(i);
                result += now;
                now = 0;
                max = cost[i];
            }
        }
        return result + now;
    }
}
