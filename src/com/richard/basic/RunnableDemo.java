package com.richard.basic;



public class RunnableDemo implements Runnable{
    private static Object staticLock = "aa";
    private Object lock = "aa";
    private Boolean flag;
    private String name;
    private Thread thread;

    RunnableDemo(String name, Boolean flag) {
        this.flag = flag;
        this.name = name;
    }


    @Override
    public void run(){
//        staticHelper(flag);
        helper(flag);
    }

    /**
     * 2 different type usage of synchronized
     * object level
     * synchronized method means synchronized(this)
     * synchronized(obj)
     *
     * class level
     * synchronized static method means synchronized(this.class)
     * synchronized (static obj)
     * @param flag
     */
//    synchronized static void staticHelper(Boolean flag) {
//        try {
////            synchronized(lock) {
//            if (flag) {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("a");
//                    Thread.sleep(50);
//                }
//            } else {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("b");
//                    Thread.sleep(50);
//                }
//            }
////            }
//        }catch (InterruptedException ex) {
//            return;
//        }
//    }

//    void staticHelper(Boolean flag) {
//        try {
//            synchronized(lock) {
//            if (flag) {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("a");
//                    Thread.sleep(50);
//                }
//            } else {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("b");
//                    Thread.sleep(50);
//                }
//            }
//            }
//        }catch (InterruptedException ex) {
//            return;
//        }
//    }

    void helper(Boolean flag) {
        try {
            synchronized(this.getClass()) {
//            synchronized(this) {
                if (flag) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("a");
                        Thread.sleep(50);
                    }
                } else {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("b");
                        Thread.sleep(50);
                    }
                }
            }
        }catch (InterruptedException ex) {
            return;
        }
    }

//    synchronized void helper(Boolean flag) {
//        try {
//            synchronized(lock) {
//                if (flag) {
//                    for (int i = 0; i < 10; i++) {
//                        System.out.println("a");
//                        Thread.sleep(50);
//                    }
//                } else {
//                    for (int i = 0; i < 10; i++) {
//                        System.out.println("b");
//                        Thread.sleep(50);
//                    }
//                }
//            }
//        }catch (InterruptedException ex) {
//            return;
//        }
//    }



//    public void start() {
//        System.out.println(name + " starting");
//        if (thread == null){
//            thread = new Thread(this, name);
//            thread.start();
//        }
//    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo("1",true);
        new Thread(runnableDemo).start();
        RunnableDemo runnableDemo1 = new RunnableDemo("2",false);
        new Thread(runnableDemo1).start();
    }
}
