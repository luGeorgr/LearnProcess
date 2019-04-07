package leetcode;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class LeetCode636 {
    public static void main(String[] argv) {
        LeetCode636 leetCode636 = new LeetCode636();
        String[] s = new String[] {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        leetCode636.exclusiveTime(2, Lists.newArrayList(s));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        final int[] res = new int[n];
        final Stack<Node> stack = new Stack<>();
        int prev = 0;
        boolean prevStarted = false;
        for (String s : logs) {
            int id = Integer.parseInt(s.substring(0, s.indexOf(':')));
            boolean started = s.charAt(s.indexOf(':') + 1) == 's';
            int time = Integer.parseInt(s.substring(s.lastIndexOf(':') + 1));
            if (started) {
                if (!stack.isEmpty()) {
                    Node node = stack.peek();
                    if (prevStarted) { //ss
                        node.time = time - node.start;
                    } else { //es
                        node.time += time - prev - 1;
                    }
                }
                stack.push(new Node(id, time));
            } else {
                Node node = stack.pop();
                if (node.time == 0) {
                    node.time = 1;
                }
                res[id] += time - prev + node.time;
            }
            prev = time;
            prevStarted = started;
        }
        return res;
    }

    private static class Node {
        int id;
        int start;
        int time;
        Node(int id, int start) {
            this.id = id;
            this.start = start;
            this.time = 0;
        }
    }
}
