package leetcode;

public class LeetCode1404 {
    public int numSteps(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == '0') {
            count += 1;
            i--;
        }
        for (; i >= 0;) {
            int j = i - 1;
            if (j < 0) {
                break;
            } else if (s.charAt(j) == '0') {
                while (s.charAt(j) == '0') {
                    j--;
                }
                count += (i - j - 1) * 2;
                i = j + 1;
            } else {
                while (j >= 0 && s.charAt(j) == '1') {
                    j--;
                }
                count += i - j + 1;
                i = j;
                if (j == 0) {
                    count += 1;
                }
            }

        }
        return count;
    }
}
