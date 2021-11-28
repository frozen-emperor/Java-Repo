package com.output;

public class RecursivePrinter {

    public static void main(String[] args) {
        countUpAndDown(0, 5);
    }

    static void countUp(int start, int end) {
        if (start > end) {
            return;
        }
        System.out.println(start);
        countUp(start + 1, end);
    }

    static void countUpAndDown(int start, int end) {
        System.out.println(start);
        if (end == start)
            return;
        countUpAndDown(start + 1, end);
        System.out.println(start);
    }

}
