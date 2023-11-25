package leetcode;

import java.util.List;

public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode pre, slow, fast;
        pre = null;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        ListNode left = pre, right;
        if (fast.next == null) {
            right = slow.next;
        } else if (slow.val != slow.next.val) {
            return false;
        } else {
            right = slow.next.next;
        }
        while (left != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
