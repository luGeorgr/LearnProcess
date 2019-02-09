package leetcode;

public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode current = head; current != null;) {
            if (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
