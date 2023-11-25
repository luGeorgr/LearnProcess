package leetcode;

import junit.framework.TestCase;

public class LeetCode2058Test extends TestCase {

    public void testNodesBetweenCriticalPoints() {
        int[] val = new int[] {1,3,2,2,3,2,2,2,7};
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0 ; i < val.length; i++) {
            cur.val = val[i];
            if (i != val.length - 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        final LeetCode2058 leetCode2058 = new LeetCode2058();
        leetCode2058.nodesBetweenCriticalPoints(head);
    }
}