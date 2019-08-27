package com.loaninfo.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.loaninfo.model.Employee;

@Service
public class CreditCardServiceImpl implements CreditCardService {
	
	public String getLoanInfo(String id) {

		Employee employee1 = new Employee();
		employee1.setSalary(50000.0);
		employee1.setLoan(true);
		employee1.setEmiAmount(100000.0);

		Employee employee2 = new Employee();
		employee2.setSalary(50000.0);
		employee2.setLoan(true);
		employee2.setEmiAmount(1000.0);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("101", employee1);
		map.put("102", employee2);

		if (map.containsKey(id)) {
			Employee employee = (Employee) map.get(id);
			if (employee.getSalary() >= 50000 && !employee.getLoan()) {
				return "Loan Approved Beauase employee have No Laons - SELECTED";
			} else if (employee.getSalary() >= 50000 && employee.getLoan()) {
				if (0.1 * employee.getSalary() >= employee.getEmiAmount()) {
					return "Loan Approved - SELECT";
				} else {
					return "Loan Rejected - Rejected";
				}
			}else
				return "Employee Salary below 50000";
		} else {
			return "Credit Card Id Not Found - Rejected";
		}
	}

}
