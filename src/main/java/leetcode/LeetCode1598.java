package leetcode;

public class LeetCode1598 {
    public int minOperations(String[] logs) {
        int times = 0;
        for (final String log : logs) {
            if (log.equals("../")) {
                times = times > 0 ? times - 1 : 0;
            } else if (log.equals("./")) {
                continue;
            } else {
                times += 1;
            }
        }
        return times;
    }
}
