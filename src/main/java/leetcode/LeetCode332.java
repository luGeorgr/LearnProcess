package leetcode;

import java.util.*;

public class LeetCode332 {
    private int length;
    public List<String> findItinerary(String[][] tickets) {
        length = tickets.length + 1;
        final Stack<String> res = new Stack<>();
        final Map<String, Node> path = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (path.get(tickets[i][0]) == null) {
                final Node node = new Node();
                node.add(tickets[i][1]);
                path.put(tickets[i][0], node);
            } else {
                path.get(tickets[i][0]).add(tickets[i][1]);
            }
        }

        for (String entry : path.keySet()) {
            path.get(entry).to.sort(String::compareTo);
        }
        res.push("JFK");
        visit(res, "JFK", path);
        return res;
    }

    private static class Node {
        private List<String> to;
        private Set<Integer> visited;
        Node () {
            to = new ArrayList<>();
            visited = new HashSet<>();
        }

        public void add(final String dest) {
            to.add(dest);
        }
    }

    private boolean visit(final Stack<String> res, final String from, final Map<String, Node> path) {
        final Node node = path.get(from);
        if (node != null) {
            for (int i = 0; i < node.to.size(); i++) {
                if (!node.visited.contains(i)) {
                    final String dest = node.to.get(i);
                    res.push(dest);
                    node.visited.add(i);
                    if (visit(res, dest, path)) {
                        return true;
                    } else {
                        res.pop();
                        node.visited.remove(i);
                    }
                }
            }
        }
        return  res.size() == length;
    }
}
