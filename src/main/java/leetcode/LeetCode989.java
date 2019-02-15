package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rouqiu
 *
 */
public class LeetCode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;
        int i = A.length - 1;
        while (K != 0 || i >= 0 || carry == 1) {
            int a = i >= 0 ? A[i] : 0;
            int b = K != 0 ? K % 10 : 0;
            K /= 10;
            i--;
            res.addFirst((a + b + carry) % 10);
            carry = a + b + carry >= 10 ? 1 : 0;
        }
        return  res;
    }
}
