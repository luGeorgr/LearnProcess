package leetcode;

import java.util.*;

public class LeetCode381 {
    public static void main(String[] argv) {
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.insert(1);
        collection.remove(0);
        collection.insert(2);
        collection.remove(1);
        collection.getRandom();
    }
}

class RandomizedCollection {
    private HashMap<Integer, LinkedList<Node>> map;
    private List<Node> list;
    private int size;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
        size = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Node addNode = new Node(val, size);
        boolean flag;
        if (map.containsKey(val)) {
            map.get(val).add(addNode);
            flag = false;
        } else {
            final LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.add(addNode);
            map.put(val, linkedList);
            flag = true;
        }
        list.add(size, addNode);
        size += 1;
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        final LinkedList<Node> nodes = map.get(val);
        final Node remove = nodes.removeLast();
        if (nodes.isEmpty()) {
            map.remove(val);
        }
        final Node changed = list.get(size - 1);
        changed.index = remove.index;
        list.set(remove.index, changed);
        size -= 1;
        list.remove(size);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(size);
        return list.get(index).value;
    }

    private static class Node {
        private int index;
        private int value;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
