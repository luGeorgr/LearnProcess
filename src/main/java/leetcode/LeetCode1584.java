package leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode1584 {
    public int minCostConnectPoints(int[][] points) {
        final PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        final Set<Integer> visited = new HashSet<>();
        for (int j = 1; j < points.length; j++) {
            queue.add(new Node(0, j, Math.abs(points[0][0] - points[j][0]) + Math.abs(points[0][1] - points[j][1])));
        }
        visited.add(0);
        int distance = 0;
        while (visited.size() != points.length) {
            final Node node = queue.poll();
            if (visited.contains(node.i) && visited.contains(node.j)) {
                continue;
            }
            if (!visited.contains(node.i)) {
                visited.add(node.i);
                for (int j = 0; j < points.length; j++) {
                    if (visited.contains(j)) {
                        continue;
                    }
                    queue.add(new Node(node.i, j, Math.abs(points[node.i][0] - points[j][0]) + Math.abs(points[node.i][1] - points[j][1])));
                }
            } else {
                visited.add(node.j);
                for (int j = 0; j < points.length; j++) {
                    if (visited.contains(j)) {
                        continue;
                    }
                    queue.add(new Node(node.j, j, Math.abs(points[node.j][0] - points[j][0]) + Math.abs(points[node.j][1] - points[j][1])));
                }
            }
            distance += node.distance;
        }
        return distance;
    }

    private class Node {
        int i;
        int j;
        int distance;
        Node(final int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }

        int getDistance() {
            return distance;
        }
    }
}
