package ru.kotin.pavel.b;

import ru.kotin.pavel.a.IClassA;

public class ClassB implements IClassB {

    private final  IClassA classA;

    public ClassB(IClassA classA) {
        this.classA = classA;
    }


    @Override
    public void doCalcInterest(double amount, double[] interest, double... rate) {
        double localRate = rate.length == 0 ? classA.getDefaultRate() : rate[0];
        interest[0] = amount * localRate;
        System.out.println("do calc: amount=" + amount + "; rate=" + localRate + "; interest=" + interest[0]);
    }
}
