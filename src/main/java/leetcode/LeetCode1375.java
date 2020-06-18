package leetcode;

public class LeetCode1375 {
    public int numTimesAllBlue(int[] light) {
        int count = 0;
        int nowMax = 0;
        int nowPre = 0;
        for (final int lightOn : light) {
            nowPre += 1;
            if (lightOn > nowMax) {
                nowMax = lightOn;
            }
            if (nowPre == nowMax) {
                count += 1;
            }
        }
        return count;
    }
}
