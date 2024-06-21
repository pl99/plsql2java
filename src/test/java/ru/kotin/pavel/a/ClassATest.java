package ru.kotin.pavel.a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassATest {

    private final ClassA a = new ClassA();


    @Test
    public void test1_setDefaultRateAndCalcDefaultInterest() {
        System.out.println("*** TEST1");
        a.setDefaultRate(0.5);
        double v_amt = a.calcDefaultInterest(1000);
        System.out.println("v_amt: " + v_amt);
        assertEquals(500, v_amt, 0.01);
    }

    @Test
    public void test2_setDefaultRateAndCalcSpecialInterestDefaultRate() {
        System.out.println("*** TEST2");
        a.setDefaultRate(0.6);
        double v_amt = a.calcSpecialInterest(1000);
        System.out.println("v_amt: " + v_amt);
        assertEquals(600, v_amt, 0.01);
    }

    @Test
    public void test3_calcSpecialInterestWithSpecificRate() {
        System.out.println("*** TEST3");
        double v_amt = a.calcSpecialInterest(1000, 0.3);
        System.out.println("v_amt: " + v_amt);
        assertEquals(300, v_amt, 0.01);
    }

    @Test
    public void test4_calcSpecialInterestWithNullRate() {
        System.out.println("*** TEST4");
        double v_amt = a.calcSpecialInterest(1000, null);
        System.out.println("v_amt: " + v_amt);
        assertEquals(200, v_amt, 0.01);  // Special rate is 0.2
    }
}
