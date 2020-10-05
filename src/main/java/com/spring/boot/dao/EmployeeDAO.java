package com.spring.boot.dao;

import java.util.List;

import com.spring.boot.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	Employee getEmployee(int id);

	void saveEmployee(Employee Employee);

	void deleteEmployee(int id);

}
