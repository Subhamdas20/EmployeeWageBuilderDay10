package com.bz.wagebuilder;

public class EmpWageBuilderArray implements EmpWageCalculation {
    /*
    * addCompanyEmpWage method is used to add company details in companyEmpWageArray
    *
    * */
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public int numOfCompany = 0;
    public CompanyEmpWage[] companyEmpWageArray;
    public EmpWageBuilderArray(int n) {
        companyEmpWageArray = new CompanyEmpWage[n];
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays, maxHrsPerMonth);
        numOfCompany++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i].toString());
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        System.out.println("Calculating Wage for Company: " + companyEmpWage.company);
        while (totalEmpHrs <= companyEmpWage.maxHrsPerMonth && totalWorkingDays < companyEmpWage.noOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
                    break;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    }
}
