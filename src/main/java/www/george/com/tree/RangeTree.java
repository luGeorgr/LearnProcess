package www.george.com.tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author rouqiu
 * not use black red tree and use binary tree
 */
public class RangeTree {

    RangeTreeNode head;
    RangeTree() {
    }

    public boolean add(final Range other) {

        return true;
    }

    public boolean remove(final Range other) {
        return true;
    }

    public boolean query(final Range other) {
        RangeTreeNode cur = head;
        while (cur != null) {
            if (other.isOverlaped(cur.range)) {
                return true;
            }
            if (other.getStart() < cur.range.getStart()) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    private class RangeTreeNode {
        RangeTreeNode left;
        RangeTreeNode right;
        Range range;
    }
}