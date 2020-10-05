package com.spring.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.EmployeeDAO;
import com.spring.boot.entity.Employee;

@Service
public class EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeService(@Qualifier("employeeDAOHibernate") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Transactional
	public Employee findEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}
}
