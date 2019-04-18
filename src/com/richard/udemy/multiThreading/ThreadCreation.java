package com.richard.udemy.multiThreading;

/**
 * Runnable lambda expression
    thread method: start(), sleep(), setName, setPriority, setUncaughtExceptionHandler(function)
 */
public class ThreadCreation {

    public static void main(String[] args) throws InterruptedException {
        //new Runnable() void run()
        Thread  thread = new Thread(() -> {
                System.out.println("We are in thread: " + Thread.currentThread().getName() + " running this thread.");
                System.out.println("We are in thread: " + Thread.currentThread().getPriority() + " current priority.");
            throw new RuntimeException("This is the sample runtime exception hehehehehheh");

        });
        thread.setName("sb123");
        thread.setPriority(Thread.MAX_PRIORITY);
        //Thread.UncaughtExceptionHandler() void uncaughtException(Thread t, Throwable e)
        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
                System.out.println("In setUncaughtExceptionHandler, message is " + e.getMessage() + "Thread is " + t.getName());
        });
        //useful thread method.
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
        Thread.sleep(500);

    }
}
