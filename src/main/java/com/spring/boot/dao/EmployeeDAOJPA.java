package com.spring.boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.boot.entity.Employee;

public class EmployeeDAOJPA implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		Employee result = entityManager.merge(employee);
		employee.setId(result.getId());
	}

	@Override
	public void deleteEmployee(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}
}
