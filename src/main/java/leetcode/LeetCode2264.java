package leetcode;

public class LeetCode2264 {
    public String largestGoodInteger(String num) {
        String maxString = "";
        int value = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (value < num.charAt(i) - '0') {
                    value = num.charAt(i) - '0';
                    maxString = num.substring(i, i + 3);
                }
            }
        }
        return maxString;
    }
}
