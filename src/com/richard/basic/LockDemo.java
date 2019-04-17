package com.richard.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo extends Thread{

    static Lock lock = new ReentrantLock();
    private String name;

    LockDemo(String name) {
        this.name = name;
    }

    public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(50);
                    System.out.println(name + "+" + i);
                    lock.lock();
                }
                catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    lock.unlock();
                }
        }

    }


    public static void main(String[] args) {
        LockDemo lockDemo1 = new LockDemo("hah2");
        LockDemo lockDemo = new LockDemo("hah1");
        lockDemo1.start();
        lockDemo.start();
    }
}
