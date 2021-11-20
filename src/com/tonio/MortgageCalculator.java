package com.tonio;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private double annualInterestRate;
    private byte periodYears;

    public MortgageCalculator(int principal, double annualInterestRate, byte periodYears)
    {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.periodYears = periodYears;
    }

    private double getMonthlyInterestRate()
    {
        return annualInterestRate / MONTHS_IN_YEAR / PERCENT;
    }

    private int getPeriodMonths()
    {
        return periodYears * MONTHS_IN_YEAR;
    }

    public double calculateMortgage()
    {
        double monthlyInterestRate = getMonthlyInterestRate();
        int periodMonths = getPeriodMonths();
        double mortgage = principal * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), periodMonths))
                / (Math.pow((1 + monthlyInterestRate), periodMonths) - 1);
        return mortgage;
    }

    public double calculateRemaniningBalance(short paymentsMade)
    {
        double monthlyInterestRate = getMonthlyInterestRate();
        int periodMonths = getPeriodMonths();
        double remainingBalance = principal * (Math.pow(1 + monthlyInterestRate, periodMonths) - Math.pow(1 + monthlyInterestRate, paymentsMade))
                    / (Math.pow(1 + monthlyInterestRate, periodMonths) - 1);
        return remainingBalance;
    }

    public double[] getRemainingBalances()
    {
        var balances = new double[getPeriodMonths()];
        for(short paymentsMade = 1; paymentsMade <= getPeriodMonths(); ++paymentsMade)
            balances[paymentsMade - 1] = calculateRemaniningBalance(paymentsMade);

        return balances;
    }
}
