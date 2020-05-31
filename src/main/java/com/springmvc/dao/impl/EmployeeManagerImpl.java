package com.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.dao.EmployeeManagerDao;
import com.springmvc.entities.Employee;

@Repository
public class EmployeeManagerImpl implements EmployeeManagerDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 获取当前线程绑定的Session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Employee> getList() {
		List<Employee> lst = new ArrayList<>();
		String hql = "FROM Employee";
		Query query = getSession().createQuery(hql);
		lst = query.list();
		return lst;
	}

	@Override
	public void deleteEmployee(int id) {
		String hql = "DELETE FROM Employee  WHERE id=" + id;
		Query query = getSession().createQuery(hql);
		query.executeUpdate();

	}

	@Override
	public void save(Employee employee) {
		Session session = getSession().getSession();
		session.save(employee);

	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = null;
		String hql = "FROM Employee  WHERE id=" + id;
		Query query = getSession().createQuery(hql);
		emp = (Employee) query.uniqueResult();
		return emp;
	}

	@Override
	public void update(Employee employee) {
		Session session = getSession().getSession();
		session.update(employee);

		
	}

}
