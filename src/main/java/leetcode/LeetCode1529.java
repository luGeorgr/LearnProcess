package leetcode;

public class LeetCode1529 {
    public int minFlips(String target) {
        int count = 0;
        int i = 0;
        while (i < target.length() && target.charAt(i) == '0') {
            i++;
        }
        while (i < target.length()) {
            count++;
            char now = target.charAt(i);
            while (i < target.length() && target.charAt(i) == now) {
                i++;
            }
        }
        return count;
    }
}
