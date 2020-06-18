package leetcode;

public class LeetCode1323 {
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        int res = 0;
        boolean changed = false;
        for (int i = 0; i < numStr.length(); i++) {
            if (changed) {
                res = res * 10 + numStr.charAt(i) - '0';
                continue;
            }
            res = res * 10 + 9;
            if (numStr.charAt(i) == '6') {
                changed = true;
            }
        }
        return res;
    }
}
