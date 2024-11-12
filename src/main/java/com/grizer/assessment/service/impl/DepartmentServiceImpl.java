package com.grizer.assessment.service.impl;

import com.grizer.assessment.entity.Department;
import com.grizer.assessment.entity.Employee;
import com.grizer.assessment.repository.DepartmentRepository;
import com.grizer.assessment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;


	@Override
	public Optional<Department> getAllDepartments(String departmentId) {
		Long id = Long.parseLong(departmentId);
		return departmentRepository.findById(id);

	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public boolean deleteDepartmentById(Long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
