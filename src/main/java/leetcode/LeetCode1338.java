package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode1338 {
    public int minSetSize(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i , map.getOrDefault(i, 0) + 1);
        }
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(var -> -var));
        priorityQueue.addAll(map.values());
        int count = 0;
        int size = 0;
        while (size * 2 < arr.length) {
            count++;
            size += priorityQueue.poll();
        }
        return count;
    }
}
