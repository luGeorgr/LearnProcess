package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode1019 {
    public int[] nextLargerNodes(ListNode head) {
        final int[] res = new int[10000];
        final Stack<Node> stack = new Stack<>();
        int count = 0;
        for (ListNode temp = head; temp != null; temp = temp.next, count += 1) {
            while (!stack.empty()) {
                if (stack.peek().value < temp.val) {
                    Node node = stack.pop();
                    res[node.index] = temp.val;
                } else {
                    break;
                }
            }
            stack.push(new Node(count, temp.val));
        }
        return Arrays.copyOf(res, count);
    }

    private static class Node {
        final int index;
        final int value;

        Node(final int index, final int value) {
            this.value = value;
            this.index = index;
        }
    }
}
