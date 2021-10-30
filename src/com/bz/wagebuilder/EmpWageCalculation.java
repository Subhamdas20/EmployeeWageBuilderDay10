package com.bz.wagebuilder;

public interface EmpWageCalculation {
    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPeronth);
    public void computeEmpWage();
    public int computeEmpWage(CompanyEmpWage companyEmpWage);
}
