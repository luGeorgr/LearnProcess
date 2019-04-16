package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode874 {
    public static void main(String[] argv) {
        LeetCode874 leetCode874 = new LeetCode874();
        int[] commands = new int[]{4, -1, 3};
        int[][] obs = new int[][]{};
        leetCode874.robotSim(commands, obs);
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashMap<Integer, HashSet<Integer>> xMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yMap = new HashMap<>();
        for (int[] obs : obstacles) {
            if (xMap.containsKey(obs[0])) {
                xMap.get(obs[0]).add(obs[1]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(obs[1]);
                xMap.put(obs[0], set);
            }
            if (yMap.containsKey(obs[1])) {
                yMap.get(obs[1]).add(obs[0]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(obs[0]);
                yMap.put(obs[1], set);
            }
        }
        int x, y, direction, max;
        max = direction = x = y = 0;
        for (int i : commands) {
            if (i == -1) {
                direction = (direction + 1 + 4) % 4;
            } else if (i == -2) {
                direction = (direction - 1 + 4) % 4;
            } else {
                if (directions[direction][0] == 0) {
                    HashSet<Integer> set = xMap.get(x);
                    while (i > 0) {
                        if (set == null) {
                            y += directions[direction][1] * i;
                            break;
                        } else if (set.contains(y + directions[direction][1])){
                            break;
                        } else {
                            i--;
                            y += directions[direction][1];
                        }
                    }
                } else {
                    HashSet<Integer> set = yMap.get(y);
                    while (i > 0) {
                        if (set == null) {
                             x += directions[direction][0] * i;
                            break;
                        } else if (set.contains(x + directions[direction][0])){
                            break;
                        } else {
                            i--;
                            x += directions[direction][0];
                        }
                    }
                }
            }
            max = Math.max(max, x * x + y * y);
        }
        return max;
    }
}
