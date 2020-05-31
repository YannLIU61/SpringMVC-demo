package com.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.DepartmentManagerDao;
import com.springmvc.entities.Department;
import com.springmvc.entities.Employee;

@Repository
public class DepartmentDaoImpl implements DepartmentManagerDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 获取当前线程绑定的Session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Department> getDepts() {
		List<Department> lst = new ArrayList<>();
		String hql = "FROM Department";
		Query query = getSession().createQuery(hql);
		lst = query.list();
		return lst;
	}

	@Override
	public Department getDept(int id) {
		String hql = "FROM Department where id ="+id;
		Query query = getSession().createQuery(hql);
		return (Department) query.uniqueResult();
	}

}
