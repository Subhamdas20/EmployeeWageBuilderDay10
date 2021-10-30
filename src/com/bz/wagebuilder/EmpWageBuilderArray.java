package com.bz.wagebuilder;

import java.util.ArrayList;
import java.util.List;

public class EmpWageBuilderArray implements EmpWageCalculation {
    /*
    * addCompanyEmpWage method is used to add company details in companyEmpWageArray
    *
    * */
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public int numOfCompany = 0;
    private List<CompanyEmpWage> companyEmpWageList;

    public EmpWageBuilderArray(int n) {
        companyEmpWageList = new ArrayList<>();
    }
    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays, maxHrsPerMonth);
        companyEmpWageList.add(companyEmpWage);
    }

    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
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
