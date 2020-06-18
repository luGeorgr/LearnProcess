package leetcode;

public class LeetCode1342 {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num != 0 && num != 1) {
            count += 1 + (num & 1);
            num >>= 1;
        }
        return count + num;
    }
}
