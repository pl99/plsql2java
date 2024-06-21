package ru.kotin.pavel.a;

public interface IClassA {
    void setDefaultRate(double rate);
    double getDefaultRate();
    double calcDefaultInterest(double amount);
    double calcSpecialInterest(double amount, Double... rate);
}
