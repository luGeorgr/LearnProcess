package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1352 {
    private List<Integer> products;
    private int zeroPosition;
    public LeetCode1352() {
        products = new ArrayList<>();
        zeroPosition = -1;
    }

    public void add(int num) {
        if (products.size() == 0 || zeroPosition == 1) {
            products.add(num);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }

        if (num == 0) {
            zeroPosition = 1;
        } else if (zeroPosition != -1) {
            zeroPosition += 1;
        }
    }

    public int getProduct(int k) {
        if (zeroPosition != -1) {
            if (k >= zeroPosition) {
                return 0;
            }
            if (k + 1 >= zeroPosition) {
                return products.get(products.size() - 1);
            }
        }
        if (products.size() <= k) {
            return products.get(products.size() - 1);
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
    }
}
