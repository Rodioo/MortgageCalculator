package com.tonio;

public class Main
{
    public static void main(String[] args)
    {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        double annualInterestRate = Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte periodYears = (byte) Console.readNumber("Period(Years): ", 1, 30);
        var mortgageCalculator = new MortgageCalculator(principal, annualInterestRate, periodYears);
        var mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.printMortgage();
        mortgageReport.printBalance();
    }
}
