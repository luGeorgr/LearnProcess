package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1765 {
    public int[][] highestPeak(int[][] isWater) {
        final int[][] result = new int[isWater.length][isWater[0].length];
        for (int[] aResult : result) {
            Arrays.fill(aResult, -1);
        }
        int totalCell = isWater.length * (isWater[0].length);
        int visited = 0;
        final Queue<Node> nodes = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    nodes.add(new Node(i, j, 0));
                    result[i][j] = 0;
                    visited++;
                }
            }
        }
        while (visited < totalCell) {
            final Node node = nodes.poll();
            if (node.j - 1 >= 0 && result[node.i][node.j - 1] == -1) {
                result[node.i][node.j - 1] = node.value + 1;
                visited++;
                nodes.add(new Node(node.i, node.j - 1, node.value + 1));
            }
            if (node.j + 1 < isWater[0].length && result[node.i][node.j + 1] == -1) {
                result[node.i][node.j + 1] = node.value + 1;
                visited++;
                nodes.add(new Node(node.i, node.j + 1, node.value + 1));
            }
            if (node.i - 1 >= 0 && result[node.i - 1][node.j] == -1) {
                result[node.i - 1][node.j] = node.value + 1;
                visited++;
                nodes.add(new Node(node.i - 1, node.j, node.value + 1));
            }
            if (node.i + 1 < isWater.length && result[node.i + 1][node.j] == -1) {
                result[node.i + 1][node.j] = node.value + 1;
                visited++;
                nodes.add(new Node(node.i + 1, node.j, node.value + 1));
            }
        }
        return result;
    }

    class Node {
        int i, j, value;
        Node (int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
