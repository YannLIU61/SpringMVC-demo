package com.springmvc.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.DepartmentManagerDao;
import com.springmvc.dao.EmployeeManagerDao;
import com.springmvc.entities.Department;
import com.springmvc.entities.Employee;

@RequestMapping("/employeeManager")
@Controller
public class EmployeeManager {

	EmployeeManagerDao employeeManagerDao = null;
	DepartmentManagerDao departmentManagerDao = null;

	public EmployeeManagerDao getEmployeeManagerDao(HttpServletRequest request) {
		if (employeeManagerDao == null) {
			ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute("ApplicationContext");
			employeeManagerDao = ac.getBean(EmployeeManagerDao.class);
		}
		return employeeManagerDao;
	}

	public DepartmentManagerDao getDepartmentManagerDao(HttpServletRequest request) {
		if (departmentManagerDao == null) {
			ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute("ApplicationContext");
			departmentManagerDao = ac.getBean(DepartmentManagerDao.class);
		}
		return departmentManagerDao;
	}

	@RequestMapping(value = "/list")
	public String getList(Map<String, Object> map, HttpServletRequest request) {
		List<Employee> lst = new ArrayList<>();
		lst = getEmployeeManagerDao(request).getList();
		map.put("employeelist", lst);
		return "list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Integer id, HttpServletRequest request) {
		getEmployeeManagerDao(request).deleteEmployee(id);

		return "redirect:/employeeManager/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, HttpServletRequest request, Map<String, Object> map) {
		Employee empEdit = getEmployeeManagerDao(request).getEmployee(id);
		map.put("employeeEdit", empEdit);
		List<Department> lst = new ArrayList<>();
		lst = getDepartmentManagerDao(request).getDepts();
		map.put("deptlist", lst);
		return "edit";
	}


	@RequestMapping(value = "/input")
	public String getDept(Map<String, Object> map, HttpServletRequest request) {
		List<Department> lst = new ArrayList<>();
		lst = getDepartmentManagerDao(request).getDepts();
		map.put("deptlist", lst);
		map.put("employee", new Employee());
		return "input";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(Map<String, Object> map, HttpServletRequest request, Employee employee) {

		Department dept = getDepartmentManagerDao(request).getDept(employee.getDepartment().getId());
		employee.setDepartment(dept);
		getEmployeeManagerDao(request).save(employee);
		return "redirect:/employeeManager/list";
	}

	@ModelAttribute
	public void getModel(@RequestParam(value = "id", required = false) Integer id, Model model,
			HttpServletRequest request) {
		if (id != null) {
			Employee empEdit = getEmployeeManagerDao(request).getEmployee(id);
			System.out.println("Gets model from database:" + empEdit);
			model.addAttribute("employeeEdit", empEdit);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee( Map<String, Object> map, HttpServletRequest request,
			@ModelAttribute(name = "employeeEdit") Employee employee) {

		Department dept = getDepartmentManagerDao(request).getDept(employee.getDepartment().getId());
		employee.setDepartment(dept);
		getEmployeeManagerDao(request).update(employee);
		return "redirect:/employeeManager/list";
	}
}
