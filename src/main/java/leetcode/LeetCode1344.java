package leetcode;

public class LeetCode1344 {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs(5.5 * minutes - 30 * hour);
        return angle > 180 ? 360 - angle : angle;
    }
}
