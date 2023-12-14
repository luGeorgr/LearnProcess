package leetcode;

public class LeetCode1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for (int i = 0 ; i < groups.length; i++) {
            final int[] group = groups[i];
            int groupIndex = 0;
            int nextIndex = index;
            boolean flag = false;
            while (index < nums.length && groupIndex < group.length) {
                if (!flag && group[0] == nums[index] && index != nextIndex) {
                    nextIndex = index;
                    flag = true;
                }
                if (nums[index] == group[groupIndex]) {
                    groupIndex++;
                    index++;
                } else {
                    groupIndex = 0;
                    if (flag) {
                        index = nextIndex;
                        flag = false;
                    } else {
                        index++;
                    }
                }
            }
            if (index >= nums.length && (groupIndex < group.length || i + 1 < groups.length)) {
                return false;
            }
        }
        return true;
    }
}
