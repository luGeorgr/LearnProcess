package leetcode;

import jdk.nashorn.internal.runtime.linker.Bootstrap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Solution1 {
    private static final int BOSS_INIT_WAIT_TIME = 5 * 60;
    private static final int BOSS_INIT_EXTRA_WAIT_TIME = 60;
    private static final int EMPLOYEE_NUM = 10;

    public static void main(final String[] argc) {
        final Boss boss = new Boss(BOSS_INIT_WAIT_TIME);
        final Meeting meeting = new Meeting(boss, EMPLOYEE_NUM);
        final List<Employee> employees = new ArrayList<>(EMPLOYEE_NUM);
        final Random random = new Random();
        for (int i = 0; i < EMPLOYEE_NUM; i++) {
            employees.add(new Employee(random.nextInt(7 * 60) + 2 * 60));
        }
        employees.sort(Comparator.comparingInt(Employee::getArriveTime));
        Thread bossThread = new Thread(meeting);
        bossThread.start();
        for (final Employee employee : employees) {
            meeting.enterEmployee(employee);
        }
    }

    private static class Employee {
        private int arriveTime;
        public Employee(int arriveTime) {
            this.arriveTime = arriveTime;
        }

        public int getArriveTime() {
            return arriveTime;
        }
    }

    private static class Meeting implements Runnable{
        private int totalEmployee;
        private volatile int nowEmployee;
        private Boss boss;
        public Meeting(final Boss boss, final int totalEmployee) {
            this.boss = boss;
            this.totalEmployee = totalEmployee;
            nowEmployee = 0;
        }

        public void enterEmployee(final Employee employee) {
            nowEmployee += 1;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(boss.getWaitTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (nowEmployee * 2 >= totalEmployee) {
                System.out.println(boss.getWaitTime() + " 开会");
                return;
            }

            try {
                Thread.sleep(BOSS_INIT_EXTRA_WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("立即开会");
        }
    }

    private static class Boss {
        private int waitTime;
        public Boss(final int waitTime) {
            this.waitTime = waitTime;
        }

        public int getWaitTime() {
            return waitTime;
        }
    }
}
