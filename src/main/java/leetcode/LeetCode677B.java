package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode677B {
    private Node root;
    private class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean word = false;
        int wordVal = 0;
        int sum = 0;
    }
    public LeetCode677B() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node temp = root;
        for (int i = 0; i < key.length(); i++) {
            if (temp.map.containsKey(key.charAt(i))) {
                Node node = temp.map.get(key.charAt(i));
                node.sum += val;
                temp = node;
            } else {
                for (; i < key.length(); i++) {
                    Node node = new Node();
                    node.sum = val;
                    temp.map.put(key.charAt(i), node);
                    temp = node;
                }
                temp.word = true;
                temp.wordVal = val;
            }

            if (i + 1 == key.length() && temp.word && temp.wordVal != val) {
                int update = -temp.wordVal;
                temp = root;
                for (i = 0; i < key.length(); i++) {
                    Node node = temp.map.get(key.charAt(i));
                    node.sum += update;
                    temp = node;
                }
            }
        }
    }

    public int sum(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.map.containsKey(prefix.charAt(i))) {
                temp = temp.map.get(prefix.charAt(i));
            } else {
                return 0;
            }
        }
        return temp.sum;
    }
}
