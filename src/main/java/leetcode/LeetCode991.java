package leetcode;

public class LeetCode991 {
    public int brokenCalc(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        }
        int step = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y /= 2;
                step++;
            } else {
                Y = (Y + 1) / 2;
                step += 2;
            }
        }
        return step + X - Y;
    }
}
