package leetcode;

import java.util.TreeMap;

public class LeetCode677A {
    TreeMap<String, Integer> map;
    public LeetCode677A() {
        map = new TreeMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        class Temp {
            int res;
        };
        final Temp res = new Temp();
        map.forEach((key, val)->{ res.res += key.startsWith(prefix) ? val : 0;});
        return res.res;
    }
}

