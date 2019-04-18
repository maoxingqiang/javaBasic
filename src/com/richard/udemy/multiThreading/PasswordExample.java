package com.richard.udemy.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordExample {

    public static final int MAX_PASSWORD = 999;


    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for (Thread thread : threads) {
            thread.start();
        }
    }


    private static class Vault {
        private int password;
        public  Vault(int password) {
            System.out.println("Password is " + password);
            this.password = password;
        }

        public boolean isCorrectPassword(int guest) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {

            }
            return guest == password;
        }
    }

    private static abstract  class HackerThread extends Thread {
        protected  Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    private  static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                System.out.println("AscendingHackerThread " + guess);
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private  static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        public void run() {
            for (int guess = MAX_PASSWORD; guess > 0; guess--) {
                System.out.println("DescendingHackerThread " + guess);
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private  static class PoliceThread extends Thread {
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
                System.out.println(i);
            }
            System.out.println("GAME OVER FOR YOU HACKERS");
            System.exit(0);
        }
    }
}
