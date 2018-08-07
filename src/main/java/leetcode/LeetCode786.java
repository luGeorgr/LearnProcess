package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        HashMap<Integer, Node> map = new HashMap<>();
        int[] res = new int[2];
        ArrayList<Node> arr = new ArrayList<>(A.length * (A.length - 1) / 2);
        
        return res;
    }

    class Node{
        int numerator;
        int denominator;
        Node (int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
}
