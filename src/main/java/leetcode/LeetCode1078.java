package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1078 {
    public String[] findOcurrences(String text, String first, String second) {
        final List<String> res = new ArrayList<>();
        final String[] words = text.split(" ");
        for (int i = 0; i + 2 < words.length; i++) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                res.add(words[i+2]);
            }
        }
        return res.toArray(new String[0]);
    }
}
