package leetcode;

public class LeetCode877 {
    public ListNode middleNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (true) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            if (fast.next != null) {
                fast = fast.next;
            } else {
                slow = slow.next;
                break;
            }
            slow = slow.next;
        }
        return slow;
    }
}
