package com.bz.wagebuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmpWageBuilderArray implements EmpWageCalculation {
    /*
     * Employee wage builder is created to calculate wage of multiple companies
     * addCompanyEmpWage method is used to add company details in companyEmpWageArray
     * used arrayList to store company details
     * used hashmap to store company name and details
     * */
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    List<CompanyEmpWage> companyEmpWageList;
    HashMap<String, CompanyEmpWage> companyToEmpWage;

    public EmpWageBuilderArray() {
        /*
         * Constructor to create arrayList and hashMap
         * */
        companyEmpWageList = new ArrayList<>();
        companyToEmpWage = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        /*
         * addCompanyEmpWage is used set all the properties in CompanyEmpWage.
         * */
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays, maxHrsPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWage.put(company, companyEmpWage);
    }

    public int getTotalWage(String company) {
        return companyToEmpWage.get(company).totalEmpWage;
    }

    public void computeEmpWage() {
        /*
        * print the employee wage
        * */
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println("");
            companyEmpWage.printDailyWage();
            System.out.println("");
            System.out.println(companyEmpWage);
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        /*
        * used to compute wage of employees
        * */
        int empHrs = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        companyEmpWage.dailyWage = new int[companyEmpWage.noOfWorkingDays];
        System.out.println("Calculating Wage for Company: " + companyEmpWage.company);
        while (totalEmpHrs <= companyEmpWage.maxHrsPerMonth && totalWorkingDays < companyEmpWage.noOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            // Case Checking
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
            companyEmpWage.dailyWage[totalWorkingDays - 1] = empHrs * companyEmpWage.empRatePerHr;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    }
}
