package leetcode;

public class LeetCode459 {
    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();
        for (int patternEnd = 0; patternEnd < size / 2; patternEnd++) {
            if (size % (patternEnd + 1) != 0) {
                continue;
            }
            boolean flag = true;
            String pattern = s.substring(0, patternEnd + 1);
            for (int j = patternEnd + 1; j < size; j += patternEnd + 1) {
                if (!pattern.equals(s.substring(j, j + patternEnd + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return  false;
    }
}
