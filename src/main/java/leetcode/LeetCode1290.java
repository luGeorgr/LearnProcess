package leetcode;

public class LeetCode1290 {
    public int getDecimalValue(ListNode head) {
        int value = 0;
        for (ListNode current = head; current != null; current = current.next) {
            value = (value << 1) + current.val;
        }
        return value;
    }
}

