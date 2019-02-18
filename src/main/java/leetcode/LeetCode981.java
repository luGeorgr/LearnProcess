package leetcode;

import java.util.HashMap;
import java.util.TreeMap;

public class LeetCode981 {

}

class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> node = map.get(key);
        if (node == null) {
            node = new TreeMap<>();
            map.put(key, node);
        }
        node.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> node = map.get(key);
        if (node == null) {
            return "";
        }
        Integer resKey = node.floorKey(timestamp);
        if (resKey == null) {
            return "";
        }
        return node.get(resKey);
    }
}

