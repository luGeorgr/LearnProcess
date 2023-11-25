package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode809 {
    class Node {
        char c;
        int count;
        Node (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public int expressiveWords(String s, String[] words) {
        List<Node> sNode = trimString(s);
        int count = 0;
        for (final String word : words) {
            List<Node> wordNode = trimString(word);
            if (check(sNode, wordNode)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(List<Node> sNode, List<Node> word) {
        if (sNode.size() != word.size()) {
            return false;
        }
        for (int i = 0; i < sNode.size(); i++) {
            Node iNode = sNode.get(i);
            Node jNode = word.get(i);
            boolean check = iNode.c == jNode.c
                    && iNode.count >= jNode.count
                    && (iNode.count >= 3 || iNode.count == jNode.count);
            if (!check) {
                return false;
            }
        }
        return true;
     }

    private List<Node> trimString(final String s) {
        final List<Node> list = new ArrayList<>();
        char current = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current == c) {
                count++;
            } else {
                list.add(new Node(current, count));
                current = c;
                count = 1;
            }
        }
        list.add(new Node(current, count));
        return list;
    }
}
