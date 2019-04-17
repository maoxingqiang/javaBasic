package com.richard.basic;

public class LockDemo1 implements Runnable {
    Thread thread;
    String name;

    LockDemo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(name + "+" + i);
                Thread.sleep(90);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }


    public void start() {
        if (thread == null) {
            thread = new Thread(this, name);
        }
        thread.start();
    }
}
