package leetcode;

public class LeetCode1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            xor[i] = ans ^ arr[i];
            ans = xor[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][0]] ^ xor[queries[i][1]] ^ arr[queries[i][0]];
        }
        return res;
    }
}
