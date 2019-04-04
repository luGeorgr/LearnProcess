package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1017 {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        final List<Integer> list = new ArrayList<>();
        final StringBuilder builder = new StringBuilder();
        while (N != 0 && N != 1) {
            if (N % 2 == 0) {
                N = N / (-2);
                list.add(0);
            } else {
                N = (N - 1) / (-2);
                list.add(1);
            }
        }
        if (N != 0) {
            list.add(N);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }
}
