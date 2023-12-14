package leetcode;

public class LeetCode393 {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            int first = data[i];
            int size = size(first);
            if (size == -1 || size + i >= data.length) {
                return false;
            }
            for (int j = 1; j <= size; j++) {
                int next = data[i + j];
                if ((next & 0b1100_0000 ^ 0b0100_0000) != 0b1100_0000) {
                    return false;
                }
            }
            i = i + size + 1;
        }
        return true;
    }

    private int size(int data) {
        if ((data & 0b1000_0000 ^ 0b1000_0000) == 0b1000_0000) {
            return 0;
        } else if ((data & 0b1110_0000 ^ 0b0010_0000) == 0b1110_0000) {
            return 1;
        } else if ((data & 0b1111_0000 ^ 0b0001_0000) == 0b1111_0000) {
            return 2;
        } else if ((data & 0b1111_1000 ^ 0b000_1000) == 0b1111_1000) {
            return 3;
        }
        return -1;
    }
}
