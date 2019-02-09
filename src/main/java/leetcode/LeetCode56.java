package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>(intervals.size());
        if  (intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, Comparator.comparing(o->o.start));
        res.add(intervals.get(0)); //这样add 不是很好， 破坏了原有的intervals.
        int index = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval resultTemp = res.get(index);
            Interval sourceTemp = intervals.get(i);
            if (sourceTemp.start <= resultTemp.end) {
                resultTemp.end = resultTemp.end > sourceTemp.end ? resultTemp.end : sourceTemp.end;
            } else {
                res.add(sourceTemp);
                index++;
            }
        }
        return res;
    }
}