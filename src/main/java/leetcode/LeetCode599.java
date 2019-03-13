package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        final String[] res = new String[list1.length];
        int min = list1.length + list2.length;
        int index = 0;
        for (int i = 0; i  <  list1.length; i++) {
            for (int j = 0; i + j <= min && j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (min == i + j) {
                        res[index++] = list1[i];
                    } else {
                        min = i + j;
                        index = 0;
                        res[index++] = list1[i];
                    }
                }
            }
        }
        final String[] ans = new String[index];
        for (int i = 0; i < index; i++) {
            ans[i] = res[i];
        }
        return ans;
    }
}
