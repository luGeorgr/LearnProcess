package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Node[] nodes = new Node[boxTypes.length];
        for (int i = 0; i < boxTypes.length; i++) {
            nodes[i] = new Node(boxTypes[i][0], boxTypes[i][1]);
        }
        Arrays.sort(nodes, Comparator.comparingInt(n -> -n.unit));
        int sum = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].num <= truckSize) {
                sum += nodes[i].num * nodes[i].unit;
                truckSize -= nodes[i].num;
            } else {
                sum += truckSize * nodes[i].unit;
                break;
            }
        }
        return sum;
    }

    private class Node {
        int num;
        int unit;
        public Node(int num, int unit) {
            this.num = num;
            this.unit = unit;
        }
    }
}
