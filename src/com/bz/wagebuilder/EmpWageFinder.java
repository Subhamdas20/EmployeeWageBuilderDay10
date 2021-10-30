package com.bz.wagebuilder;

import java.util.Scanner;

public class EmpWageFinder {
    /*
    * main method
    * */
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************\n");
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter No. of Companies");
        num = scanner.nextInt();
        EmpWageCalculation empWageBuilder = new EmpWageBuilderArray();
        for (int i = 0; i < num; i++) {
            System.out.println(
                    "Enter Company Details as given:\n CompanyName EmployeeRatePerHr NoOfWorkingDays MaxHrsPerMonth");
            empWageBuilder.addCompanyEmpWage(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        System.out.println("");
        empWageBuilder.computeEmpWage();
        System.out.println("Enter Company Name: ");
        System.out.println("Employee Wage: "+empWageBuilder.getTotalWage(scanner.next()));
    }
}