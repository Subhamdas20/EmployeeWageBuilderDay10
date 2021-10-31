package com.bz.wagebuilder;

public interface EmpWageCalculation {
    /*
    * Used interface EmpWageCalculation
    * */
    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth);
    public void computeEmpWage();
    public int computeEmpWage(CompanyEmpWage companyEmpWage);
    public int getTotalWage(String company);
}
