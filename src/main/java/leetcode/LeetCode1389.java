package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        final List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < index.length; i++) res[i] = list.get(i);
        return res;
    }
}
