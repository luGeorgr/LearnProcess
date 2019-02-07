package leetcode;

public class LeetCode941 {
    public boolean validMountainArray(int[] A) {
        int index = 0;
        for (; index + 1 < A.length && A[index] < A[index+1]; index++);
        if (index + 1 >= A.length || A[index] == A[index + 1] || index == 0) {
            return false;
        }

        for (; index + 1 < A.length && A[index] > A[index + 1]; index++);
        return index +  1 >= A.length;
    }
}
