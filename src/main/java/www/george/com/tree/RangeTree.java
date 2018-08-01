package www.george.com.tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author rouqiu
 * not use black red tree and use binary tree s
 */
public class RangeTree {
    /**
     *  dummy node
     */
    RangeTreeNode head;
    RangeTree() {
        head = new RangeTreeNode();
    }

    public boolean add(final Range other) {
        RangeTreeNode a;
        return true;
    }

    public boolean remove(final Range other) {
        return true;
    }
}

class RangeTreeNode {
    RangeTreeNode left;
    RangeTreeNode right;
    Range range; 
}