package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>(intervals.size());
        Collections.sort(intervals, Comparator.comparing(o->o.start));

        return res;
    }
}



class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}