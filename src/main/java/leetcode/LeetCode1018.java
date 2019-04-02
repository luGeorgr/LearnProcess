package leetcode;

import java.util.ArrayList;
import java.util.List;
public class LeetCode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        final List<Boolean> list = new ArrayList<>(A.length);
        int num = 0;
        for (int i : A) {
            num = num * 2 + i;
            if (num % 5 == 0) {
                list.add(Boolean.TRUE);
            } else {
                list.add(Boolean.FALSE);
            }
            num = num % 5;
        }
        return list;
    }
}
