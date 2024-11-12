package com.grizer.assessment.service;

import com.grizer.assessment.entity.Department;
import com.grizer.assessment.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
	public Optional<Department> getAllDepartments(String departmentId);

	public Department saveDepartment(Department department);
	public boolean deleteDepartmentById(Long id);

}
