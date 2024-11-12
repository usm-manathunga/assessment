package com.grizer.assessment.service.impl;

import com.grizer.assessment.entity.Employee;
import com.grizer.assessment.repository.EmployeeRepository;
import com.grizer.assessment.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));
	}

	@Override
	public List<Employee> findAllByDepartment(String departmentName) {
		return employeeRepository.findByDepartment_Name(departmentName);

	}

	@Override
	public Employee update(Long id, Employee updatedEmployee) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}
}
