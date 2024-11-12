package com.grizer.assessment.service;

import com.grizer.assessment.entity.Employee;

import java.util.List;

public interface EmployeeService {
	public Employee save(Employee employee);
	public Employee findById(Long id);
	public List<Employee> findAllByDepartment(String departmentName);
	public Employee update(Long id, Employee updatedEmployee);
	public void delete(Long id);
}
