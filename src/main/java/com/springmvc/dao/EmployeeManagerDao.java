package com.springmvc.dao;

import java.util.List;

import com.springmvc.entities.Employee;

public interface EmployeeManagerDao {
	public List<Employee> getList();

	public void deleteEmployee(int id);
	
	public void save(Employee employee);
	
	public void update(Employee employee);
	
	public Employee getEmployee(int id);
}
