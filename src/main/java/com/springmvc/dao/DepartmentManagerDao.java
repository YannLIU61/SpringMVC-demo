package com.springmvc.dao;

import java.util.List;

import com.springmvc.entities.Department;


public interface DepartmentManagerDao {
	public  List<Department> getDepts();
	
	public Department getDept(int id);
}
