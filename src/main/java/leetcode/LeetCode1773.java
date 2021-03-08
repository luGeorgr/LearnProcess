package leetcode;

import java.util.List;

public class LeetCode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index;
        if ("type".equals(ruleKey)) {
            index = 0;
        } else if ("color".equals(ruleKey)) {
            index = 1;
        } else {
            index = 2;
        }
        int count = 0;
        for (final List<String> item : items) {
            if (ruleValue.equals(item.get(index))) {
                count++;
            }
        }
        return count;
    }
}
