package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1704 {
    public boolean halvesAreAlike(String s) {
        final Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int sum = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (i < s.length() / 2) {
                    left++;
                }
                sum++;
            }
        }
        return left * 2 == sum;
    }
}
