package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n && index < target.length; i++) {
            if (i == target[index]) {
                res.add("Push");
                index++;
            } else if (i < target[index]) {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}
