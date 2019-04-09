package leetcode;

import java.util.*;

public class LeetCode870 {
    public static void main(String[] argv) {
        LeetCode870 leetCode870 = new LeetCode870();
        int[] A = new int[]{2,0,4,1,2};
        int[] B = new int[]{1,3,0,0,2};
        leetCode870.advantageCount(A, B);
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        Node[] nodes = new Node[B.length];
        for (int i = 0; i < B.length; i++) {
            nodes[i] = new Node(B[i], i);
        }
        Arrays.sort(A);
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.value));
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            for (; j < A.length;) {
                if (A[j] > nodes[i].value) {
                    res[nodes[i].index] = A[j];
                    j++;
                    break;
                } else {
                    stack.push(A[j]);
                    j++;
                }
            }
            if (j >= A.length) {
                int k = A.length - 1;
                while (!stack.isEmpty()) {
                    res[nodes[k].index] = stack.pop();
                    k--;
                }
                break;
            }
        }
        return res;
    }

    private static class Node {
        int index;
        int value;
        public Node(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }
}
