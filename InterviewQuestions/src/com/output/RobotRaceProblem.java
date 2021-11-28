package com.output;

import java.util.ArrayList;
import java.util.List;

public class RobotRaceProblem {

    static List<RoboThread> ranks = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        RoboThread joe = new RoboThread(3, "joe", "FRFLLFRF");
        RoboThread bill = new RoboThread(1, "bill", "FFFFFLF");
        RoboThread jim = new RoboThread(2, "jim", "LFRF");

        joe.start();
        bill.start();
        jim.start();

        joe.join();
        bill.join();
        jim.join();

        System.out.println("The race has ENDED!");

        int rank = 1;
        for (RoboThread robo : ranks) {
            System.out.println(robo.name + " is #" + rank++ + ", at [" + robo.x + "," + robo.y + "]");
        }
    }

}

class RoboThread extends Thread {
    int delay;

    String name;

    String inputPath;

    int x = 0, y = 0;

    char dir = 'n';

    int time = 0;

    public RoboThread(int delay, String name, String inputPath) {
        super();
        this.delay = delay;
        this.name = name;
        this.inputPath = inputPath;
    }

    @Override
    public void run() {
        for (char c : inputPath.toCharArray()) {
            switch (c) {
            case 'F':
                switch (dir) {
                case 'n':
                    y++;
                    break;
                case 's':
                    y--;
                    break;
                case 'e':
                    x++;
                    break;
                case 'w':
                    x--;
                    break;
                }
                break;
            case 'L':
                switch (dir) {
                case 'n':
                    dir = 'w';
                    break;
                case 's':
                    dir = 'e';
                    break;
                case 'e':
                    dir = 'n';
                    break;
                case 'w':
                    dir = 's';
                    break;
                }
                break;
            case 'R':
                switch (dir) {
                case 'n':
                    dir = 'e';
                    break;
                case 's':
                    dir = 'w';
                    break;
                case 'e':
                    dir = 's';
                    break;
                case 'w':
                    dir = 'n';
                    break;
                }
                break;
            }

            System.out.println(time + "s name : " + name + " pos:" + x + " : " + y + " went " + c);
            try {
                Thread.sleep(delay * 1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            time += delay;
        }
        RobotRaceProblem.ranks.add(this);
    }
}
