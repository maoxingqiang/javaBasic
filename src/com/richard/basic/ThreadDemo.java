package com.richard.basic;

public class ThreadDemo extends Thread{

    /**
     * Class 锁
     */
    final static Object staticLock = new Object();
    /**
     * 对象锁
     */
    final Object lock = new Object();

    String name;

    ThreadDemo(String name) {
        this.name = name;
    }

    public  void run() {
        synchronized(lock) {
            for (int i = 0; i < 10; i++) {
                System.out.println("asdasd + " + name);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo("1");
        threadDemo.start();
        ThreadDemo threadDemo1 = new ThreadDemo("2");
        threadDemo1.start();

    }
}
