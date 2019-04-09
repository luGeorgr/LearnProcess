package leetcode;

public class LeetCode868 {
    public int binaryGap(int N) {
        int max = 0;
        int before = -1;
        int pos = 0;
         while (N !=  0) {
             if (N % 2 == 1) {
                 if (before != -1 && max < pos -before) {
                     max = pos - before;
                 }
                 before = pos;
             }
             N /= 2;
             pos++;
         }
         return max;
    }
}
