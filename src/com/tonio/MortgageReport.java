package com.tonio;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculator calculatorObj;

    public MortgageReport(MortgageCalculator calculatorObj) {
        this.calculatorObj = calculatorObj;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printBalance()
    {
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for(double balance : calculatorObj.getRemainingBalances())
            System.out.println(currency.format(balance));
    }

    public void printMortgage()
    {
        double mortgage = calculatorObj.calculateMortgage();
        String formattedMortgage = currency.format(mortgage);
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        System.out.print("Monthly payments: " + formattedMortgage);
    }
}
