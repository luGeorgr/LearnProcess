package leetcode;

public class LeetCode2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minIndex = -1;
        int maxIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        ListNode before = head;
        ListNode cur = head.next;
        int index = 1;
        for (; cur != null && cur.next != null; before = cur, cur = cur.next, index++) {
            ListNode after = cur.next;
            if (cur.val > before.val && cur.val > after.val
                    || cur.val < before.val && cur.val < after.val) {
                if (minIndex == -1) {
                    minIndex = index;
                }
                if (maxIndex != -1 && index - maxIndex < minDistance) {
                    minDistance = index - maxIndex;
                }
                maxIndex = index;
            }
        }
        if (minIndex == -1 || minIndex == maxIndex) {
            return new int[] {-1, -1};
        }
        return new int[] {minDistance, maxIndex - minIndex};
    }
}
