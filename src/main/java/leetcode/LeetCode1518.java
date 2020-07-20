package leetcode;

public class LeetCode1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int result = 0;
        do {
            empty += numBottles;
            result += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        } while (numBottles != 0);
        return result;
    }
}
