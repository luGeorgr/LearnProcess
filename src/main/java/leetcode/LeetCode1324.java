package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode1324 {
    public List<String> printVertically(String s) {
        final List<StringBuilder> stringBuilders = new ArrayList<>();
        int before = 0;
        int builderIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                before += 1;
                builderIndex = 0;
                continue;
            }
            if (builderIndex < stringBuilders.size()) {
                StringBuilder temp = new StringBuilder();
                for (int j = stringBuilders.get(builderIndex).length(); j < before; j++) {
                    temp.append(' ');
                }
                temp.append(s.charAt(i));
                stringBuilders.get(builderIndex).append(temp);
            } else {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < before; j++) {
                    temp.append(' ');
                }
                temp.append(s.charAt(i));
                stringBuilders.add(temp);
            }
            builderIndex += 1;
        }
        return stringBuilders.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }
}
