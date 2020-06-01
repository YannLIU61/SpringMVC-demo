package com.springmvc.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.dao.DepartmentManagerDao;
import com.springmvc.dao.EmployeeManagerDao;
import com.springmvc.entities.Department;
import com.springmvc.entities.Employee;

@RequestMapping("/employeeManager")
@Controller
public class EmployeeManager {

	@Autowired
	private EmployeeManagerDao employeeManagerDao;

	@Autowired
	private DepartmentManagerDao departmentManagerDao;

	@RequestMapping(value = "/list")
	public String getList(Map<String, Object> map) {
		List<Employee> lst = new ArrayList<>();
		lst = employeeManagerDao.getList();
		map.put("employeelist", lst);
		return "list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Integer id) {
		employeeManagerDao.deleteEmployee(id);

		return "redirect:/employeeManager/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Map<String, Object> map) {
		Employee empEdit = employeeManagerDao.getEmployee(id);
		map.put("employeeEdit", empEdit);
		List<Department> lst = new ArrayList<>();
		lst = departmentManagerDao.getDepts();
		map.put("deptlist", lst);
		return "edit";
	}

	@RequestMapping(value = "/input")
	public String getDept(Map<String, Object> map) {
		List<Department> lst = new ArrayList<>();
		lst = departmentManagerDao.getDepts();
		map.put("deptlist", lst);
		map.put("employee", new Employee());
		return "input";
	}

	/**
	 * BindingResult 必须紧挨着绑定结果对象, 中间不能有其他的入参
	 * 
	 * @param employee
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@Valid Employee employee, BindingResult result, Map<String, Object> map) {

		System.out.println("Save new employee " + employee);
		if (result.getErrorCount() > 0) {
			System.out.println("出错了.....");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + " : " + error.getDefaultMessage());
			}
			// 如果出错就转向定制的页面, BindingResult(Errors)中储存错误信息传回jsp页面
			// <form:errors path="email"></form:errors>
			map.put("deptlist", departmentManagerDao.getDepts());
			return "input";
		} else {
			Department dept = departmentManagerDao.getDept(employee.getDepartment().getId());
			employee.setDepartment(dept);
			employeeManagerDao.save(employee);
			return "redirect:/employeeManager/list";
		}

	}

	@ModelAttribute
	public void getModel(@RequestParam(value = "id", required = false) Integer id, Model model,
			HttpServletRequest request) {
		if (id != null) {
			Employee empEdit = employeeManagerDao.getEmployee(id);
			System.out.println("Gets model from database:" + empEdit);
			model.addAttribute("employeeEdit", empEdit);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute(name = "employeeEdit") Employee employee) {

		Department dept = departmentManagerDao.getDept(employee.getDepartment().getId());
		employee.setDepartment(dept);
		employeeManagerDao.update(employee);
		return "redirect:/employeeManager/list";
	}

	@RequestMapping(value = "/testConversionService", method = RequestMethod.POST)
	public String testConversionService(@RequestParam("employee") Employee employee) {
		employeeManagerDao.save(employee);
		return "redirect:/employeeManager/list";
	}
	/**
	 * JSON
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/testJson")
	public List<Employee> testJSON() {
		return employeeManagerDao.getList();
	}
}
