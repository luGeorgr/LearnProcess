package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Solution2 {
    private static final double FACTORY_TOTAL_AREA = 100;
    private static final int MONTH_BOARDS_NUM = 100;

    public static void main(String[] argc) {
        final Factory factory = new Factory(FACTORY_TOTAL_AREA);
        final Random random = new Random();
        final List<Board> boards = new ArrayList<>();
        for (int i = 0; i < MONTH_BOARDS_NUM; i++) {
            boards.add(new Board(random.nextDouble() * 100, random.nextDouble() * 100));
        }
        boards.sort(Comparator.comparingDouble(Board::getUnitPrice).reversed());
        boards.forEach(factory::makeBoard);
        System.out.println(factory.getNowPricePrice());
    }

    public static class Board {
        private double area;
        private double totalPrice;

        public Board(final double area, final double totalPrice) {
            this.area = area;
            this.totalPrice = totalPrice;
        }

        public double getUnitPrice() {
            return totalPrice / area;
        }
    }

    public static class Factory {
        private double totalArea;
        private double nowArea;
        private double nowPrice;

        public Factory(final double totalArea) {
            this.totalArea = totalArea;
            nowPrice = nowArea = 0;
        }

        public boolean makeBoard(final Board board) {
            if (board.area + nowArea > totalArea) {
                return false;
            }
            nowArea += board.area;
            nowPrice += board.totalPrice;
            return true;
        }

        public double getNowPricePrice() {
            return nowPrice;
        }
    }
}
