package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    private List<String> res;
    private int[] seg;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        seg = new int[4];
        char[] nums = s.toCharArray();
        visit(nums, 0, 0);
        return res;
    }

    private void visit(final char[] nums, final int begin, final int depth) {
        if (depth == 4 && begin == nums.length) {
            add();
            return;
        }
        if (nums.length - begin > (4 - depth) * 3) {
            return;
        }
        int num = 0;
        for (int i = begin; begin + 3 >= i && i < nums.length; i++) {
            num = num * 10 + nums[i] - '0';
            seg[depth] = num;
            if (num > 255) {
                break;
            } else if (num == 0) {
                visit(nums, i + 1, depth + 1);
                break;
            } else {
                visit(nums, i + 1, depth + 1);
            }
        }
    }

    private void add() {
        final StringBuilder builder = new StringBuilder()
                .append(seg[0]).append('.')
                .append(seg[1]).append('.')
                .append(seg[2]).append('.')
                .append(seg[3]);
        res.add(builder.toString());
    }
}
