package com.richard.udemy.multiThreading.threadCoordination;

import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args) {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        System.out.println(complexCalculation.calculateResult(new BigInteger("10"),new BigInteger("2"),new BigInteger("10"),new BigInteger("2")));
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
        thread1.start();
        thread2.start();
        try {
            thread1.join(500);
            thread2.join(500);
        } catch (InterruptedException ex) {

        }

        result = thread1.getResult().add(thread2.getResult());

        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i  = i.add(BigInteger.ONE)) {
                System.out.println(i.toString());
                System.out.println(i.compareTo(power));
                result = result.multiply(base);

            }

           /*
           Implement the calculation of result = base ^ power
           */
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
