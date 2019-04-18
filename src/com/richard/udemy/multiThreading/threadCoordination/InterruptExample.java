package com.richard.udemy.multiThreading.threadCoordination;

import java.math.BigInteger;


/**
 * When calling interrupt() from another thread.
 * We need to have isInterrupted() check in the interrupted thread.
 *
 * interrupt() will cause Thread.sleep throw InterruptedException
 */
public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("10000000000")));
        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            //TODO
            try {
                Thread.sleep(500000);

            } catch (InterruptedException ex) {
                System.out.println("exiting  blocking thread. ");
            }
        }
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;


        LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }


        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i=i.add(BigInteger.ONE)){
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException ex) {
                    System.out.println("InterruptedException");
                    return new BigInteger("0");
                }
                /**
                 *  This part is required when we are using interrupt()
                 */
//                if (Thread.currentThread().isInterrupted()) {
//                    return BigInteger.ZERO;
//                }
                result = result.multiply(base);
            }
            return result;
        }
    }

}
