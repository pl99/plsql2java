package ru.kotin.pavel.a;

import ru.kotin.pavel.b.ClassB;
import ru.kotin.pavel.b.IClassB;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClassA implements IClassA {
    private final ThreadLocal<Double> defaultRate;
    private final Lock lock = new ReentrantLock();
    private final IClassB classB = new ClassB(this);

    public ClassA() {
        defaultRate = ThreadLocal.withInitial(() -> 0.1);
        System.out.println("init default rate to value: " + defaultRate.get());
    }

    @Override
    public void setDefaultRate(double rate) {
        double oldRate = defaultRate.get();
//        lock.lock();
//        try {
        defaultRate.set(rate);
//        } finally {
//            lock.unlock();
//        }
        System.out.println("change default rate from " + oldRate + " to " + rate);
    }

    @Override
    public double getDefaultRate() {
        return defaultRate.get();
    }

    @Override
    public double calcDefaultInterest(double amount) {
        double[] interest = new double[1];
        classB.doCalcInterest(amount, interest, getDefaultRate());
        return interest[0];
    }


    @Override

    public double calcSpecialInterest(double amount, Double... rate) {
        double interestRate = (rate == null) ? getSpecialRate() : rate.length == 0 ? getDefaultRate() : rate[0];
        double[] interest = new double[1];
        classB.doCalcInterest(amount, interest, interestRate);
        return interest[0];
    }

    private double getSpecialRate() {
        System.out.println("special rate requested");
        return 0.2;
    }
}
