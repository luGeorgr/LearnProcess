package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            if (selfDividingNumber(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean selfDividingNumber(int num) {
        int n = num;
        do {
            int div = n % 10;
            if (div == 0 || num % div != 0) {
                return false;
            } else {
                n = n / 10;
            }
        } while(n != 0);
        return true;
    }
}
