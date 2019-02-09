package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode986 {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        final List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i != A.length && j != B.length) {
            if (A[i].start <= B[j].start) {
                if (B[j].start > A[i].end) {
                    i++;
                } else if (B[j].end <= A[i].end) {
                    list.add(new Interval(B[j].start, B[j].end));
                    j++;
                } else {
                    list.add(new Interval(B[j].start, A[i].end));
                    i++;
                }
            } else {
                if (A[i].start > B[j].end) {
                    j++;
                } else if (A[i].end <= B[j].end) {
                    list.add(new Interval(A[i].start, A[i].end));
                    i++;
                } else {
                    list.add(new Interval(A[i].start, B[j].end));
                    j++;
                }
            }
        }
        Interval[] res = new Interval[list.size()];
        for (int index = 0; index < res.length; index++) {
            res[index] = list.get(index);
        }
        return  res;
    }
}
