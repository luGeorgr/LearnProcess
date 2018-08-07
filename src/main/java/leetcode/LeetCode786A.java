package leetcode;

import java.util.*;

public class LeetCode786A {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int[] res = new int[2];
        PriorityQueue<Node> heap = new PriorityQueue<>(K);
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > i; j--) {
                Node temp = new Node(A[i], A[j]);
                if (heap.size() < K) {
                    heap.add(temp);
                } else {
                    if (heap.peek().compareTo(temp) < 0) {
                        heap.poll();
                        heap.add(temp);
                    } else {
                        break;
                    }
                }
            }
        }
        res[0] = heap.peek().numerator;
        res[1] = heap.peek().denominator;
        return res;
    }

    class Node implements Comparable{
        int numerator;
        int denominator;
        Node (int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        /*
        **  < 0 : this > other
         */
        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
            return denominator * other.numerator - numerator * other.denominator;
        }
    }
}
