package com.caicongyang.concurrent;


/**
 * 多线程并发打出123
 */
public class SequentialPrint {


    volatile static int i = 0;

    static class First implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (i % 3 == 0) {
                    System.out.println(1);
                    i++;
                }
            }
        }
    }


    static class Second implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (i % 3 == 1) {
                    System.out.println(2);
                    i++;
                }
            }
        }
    }


    static class Third implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (i % 3 == 2) {
                    System.out.println(3);
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new Second()).start();
        new Thread(new First()).start();
        new Thread(new Third()).start();

    }


}
