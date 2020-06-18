package leetcode;

import java.util.*;

public class LeetCode1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] root =  new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            root[i] = i;
        }
        for (final List<Integer> pair : pairs) {
            int root1 = findRoot(root, pair.get(0));
            int root2 = findRoot(root, pair.get(1));
            if (root1 == root2) {
                continue;
            } else if (root1 < root2){
                root[root2] = root1;
            } else {
                root[root1] = root2;
            }
        }
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < root.length; i++) {
            if (map.containsKey(findRoot(root, i))) {
                map.get(root[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(root[i], list);
            }
        }
        final char[] result = new char[s.length()];
        for(Integer key : map.keySet()) {
            char[] tmp = new char[map.get(key).size()];
            for(int i = 0; i < tmp.length; i++) {
                tmp[i] = s.charAt(map.get(key).get(i));
            }
            Arrays.sort(tmp);

            for(int i = 0; i < tmp.length; i++) {
                result[map.get(key).get(i)] = tmp[i];
            }
        }
        return new String(result);
    }

    private int findRoot(int[] root, int index) {
        if (root[index] == index) {
            return index;
        }
        root[index] = findRoot(root, root[index]);
        return root[index];
    }
}
