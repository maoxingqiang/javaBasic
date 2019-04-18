package com.richard.udemy.multiThreading.threadCoordination;

import java.math.BigInteger;
import java.util.*;


/**
 * Do not rely on the order of execution
 * Always use thread coordination
 * Design code for worst case scenario
 * Threads may take unreasonably long time and ALWAYS use the Thread.join() with a time limit.
 */
public class JoinExample {
    public static void main(String[] args)  throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(10000000L, 3435L, 35435L,2324L, 4656L, 2L, 2435L, 5566L);
        List<FactorialThread> threads = new ArrayList<>();
        for(long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }
        for (Thread thread : threads){
            thread.start();
        }
        for (Thread thread : threads){
            try {
//                thread.join();
                thread.join(2000);

            }catch (InterruptedException ex) {

            }
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println(i + " is finished");
            } else {
                System.out.println(i +" is progress");
            }
        }
    }

    private static class FactorialThread extends Thread {
        private  long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }

}
