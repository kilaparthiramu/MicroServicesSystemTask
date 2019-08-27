package com.loaninfo.model;

public class Employee {

	private Double salary;
	private boolean loan;
	private Double emiAmount;

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public boolean getLoan() {
		return loan;
	}

	public void setLoan(boolean loan) {
		this.loan = loan;
	}

}
