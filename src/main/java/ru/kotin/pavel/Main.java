package ru.kotin.pavel;

public class Main {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        double v_amt;
        System.out.println("*** TEST1");
        a.setDefaultRate(0.5);
        v_amt = a.calcDefaultInterest(1000);

        System.out.println("*** TEST2");
        a.setDefaultRate(0.6);
        v_amt = a.calcSpecialInterest(1000);

        System.out.println("*** TEST3");
        v_amt = a.calcSpecialInterest(1000, 0.3);

        System.out.println("*** TEST4");
        v_amt = a.calcSpecialInterest(1000, null);

    }
}