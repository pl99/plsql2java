package ru.kotin.pavel;

public class ClassB {
    public static double doCalcInterest(double amount, double rate) {
        double interest = amount * rate;
        System.out.println("do calc: amount=" + amount + "; rate=" + rate + "; interest=" + interest);
        return interest;
    }
}
