package com.grizer.assessment.controller;

import com.grizer.assessment.entity.Department;
import com.grizer.assessment.entity.Employee;
import com.grizer.assessment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("{id}")
	public Optional<Department> getAllDepartments(@PathVariable String id) {
		return departmentService.getAllDepartments(id);
	}

	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}


	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable String id, @RequestBody Department department) {
		Optional<Department> existingDepartment = departmentService.getAllDepartments(id);
		if (existingDepartment.isPresent()) {
			department.setId(Long.parseLong(id));
			return departmentService.saveDepartment(department);
		} else {
			throw new RuntimeException("Department not found with id: " + id);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
		boolean isDeleted = departmentService.deleteDepartmentById(id);

		if (isDeleted) {
			return ResponseEntity.ok("Department deleted successfully");
		} else {
			return ResponseEntity.status(404).body("Department not found with id: " + id);
		}
	}




}
