package leetcode;

import java.util.Stack;

public class LeetCode1021 {
    public String removeOuterParentheses(String S) {
        int stack = 1;
        StringBuilder builder = new StringBuilder();
        int begin = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack++;
            } else {
                stack--;
                if (stack == 0) {
                    builder.append(S.substring(begin+1, i));
                    begin = i + 1;
                }
            }
        }
        return builder.toString();
    }
}
