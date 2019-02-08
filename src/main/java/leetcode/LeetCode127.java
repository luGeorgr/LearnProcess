package leetcode;

import java.util.*;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, Integer> visited = new HashMap<>(wordList.size() + 1);
        Queue<String> queue = new LinkedList<>();
        visited.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty() && !visited.containsKey(endWord)) {
            String cur = queue.poll();
            int pos = visited.get(cur);
            Iterator<String> iterator = wordList.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (hasOneDifferent(s, cur)) {
                    visited.put(s, pos + 1);
                    queue.offer(s);
                    iterator.remove();
                }
            }
        }

        return visited.getOrDefault(endWord, 0);
    }

    private boolean hasOneDifferent(final String a, final String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            count = a.charAt(i) != b.charAt(i) ? count + 1 : count;
        }
        return count == 1;
    }
}
