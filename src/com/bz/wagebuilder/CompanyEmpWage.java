package com.bz.wagebuilder;

public class CompanyEmpWage {

    public final String company;
    public final int empRatePerHr;
    public final int noOfWorkingDays;
    public final int maxHrsPerMonth;
    public int totalEmpWage;
    public int dailyWage[];

    public CompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.noOfWorkingDays = noOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public void printDailyWage() {
        for (int i = 0; i < dailyWage.length; i++) {
            System.out.println("Day " + (i + 1) + "\t Wage = " + dailyWage[i]);
        }
    }

    @Override
    public String toString() {
        return "Total Emp Wage for Company : " + company + " is : " + totalEmpWage + "\n";
    }
}
