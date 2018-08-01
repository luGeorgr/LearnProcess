package www.george.com.tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author rouqiu
 *
 */
public class RangeTree extends TreeSet<Range> {
    public boolean insert(Range node) {
        for (Range range : this) {

        }
        return true;
    }

    public RangeTree() {
        super(Comparator.comparing(range -> range.start));
    }
}

class Range {
    public int start;
    public int end;
    public int max;
}