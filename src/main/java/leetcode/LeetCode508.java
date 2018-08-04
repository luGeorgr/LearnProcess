package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        postTravel(root, map);
        int temp = 0;
        for (Integer i : map.values()) {
            if (i > temp) {
                temp = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = temp;
        map.forEach((k,v)->{
            if(v.equals(max)) {
                list.add(k);
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int postTravel (TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int lval = postTravel(root.left, map);
        int rval = postTravel(root.right, map);
        root.val = lval + rval + root.val;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        return root.val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}