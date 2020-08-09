package leetcode;

import java.util.Stack;

public class LeetCode1544 {
    public String makeGood(String s) {
        final Stack<Character> stack = new Stack<>();
        final int check = Math.abs('A' - 'a');
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            final char now = stack.peek();
            if (Math.abs(c - now) ==  check) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        final StringBuilder builder = new StringBuilder();
        for (char c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }
}
