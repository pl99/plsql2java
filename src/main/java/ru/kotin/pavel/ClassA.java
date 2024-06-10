package ru.kotin.pavel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClassA {
    private final ThreadLocal<Double> defaultRate;
    private final Lock lock = new ReentrantLock();

    public ClassA() {
        defaultRate = ThreadLocal.withInitial(() -> 0.1);
        System.out.println("init default rate to value: " + defaultRate.get());

    }

    public void setDefaultRate(double rate) {
        lock.lock();
        try {
            System.out.println("change default rate from " + defaultRate.get() + " to " + rate);
            defaultRate.set(rate);
        } finally {
            lock.unlock();
        }
    }

    public double getDefaultRate() {
        return defaultRate.get();
    }

    public double calcDefaultInterest(double amount) {
        double interest = ClassB.doCalcInterest(amount, getDefaultRate());
        return interest;
    }

    public double calcSpecialInterest(double amount, Double rate) {
        double interestRate = (rate == null) ? getSpecialRate() : rate;
        double interest = ClassB.doCalcInterest(amount, interestRate);
        return interest;
    }

    public double calcSpecialInterest(double amount) {
        double interestRate = getDefaultRate();
        ;
        double interest = calcSpecialInterest(amount, interestRate);
        return interest;
    }

    private double getSpecialRate() {
        System.out.println("special rate requested");
        return 0.2;
    }
}
