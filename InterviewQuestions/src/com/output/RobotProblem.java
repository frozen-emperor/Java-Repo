package com.output;

public class RobotProblem {

    public static void main(String[] args) {
        String input = "LFFFRFFFRRFFF";
        calculatePath(input);
    }

    private static void calculatePath(String input) {
        int x = 0, y = 0;
        char dir = 'n';

        for (char c : input.toCharArray()) {
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

        }
        System.out.println(x + " : " + y);
    }

}
