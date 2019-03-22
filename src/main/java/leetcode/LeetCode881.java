package leetcode;

import java.util.Arrays;

public class LeetCode881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0, j = people.length - 1;
        for (; i < j; ) {
            if (people[i] + people[j] <= limit) {
                count++;
                i++; j--;
            } else {
                count++;
                j--;
            }
        }
        return i == j ? count + 1 : count;
    }
}
