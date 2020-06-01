package com.springmvc.handlers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.entities.Department;
import com.springmvc.entities.Employee;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		if (source != null) {
			String[] vals = source.split("-");
			if (vals != null && vals.length == 4) {
				String lastName = vals[0];
				String email = vals[1];
				String gender = vals[2];
				Department dept = new Department(Integer.parseInt(vals[3]));
				Employee em = new Employee(lastName, email, gender, dept);
				System.out.println(em);
				return em;
			}
		}
		return null;
	}

}
