package com.grizer.assessment.controller;

import com.grizer.assessment.entity.Employee;
import com.grizer.assessment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		System.out.println("employee :"+employee);
		return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam String department) {
		return new ResponseEntity<>(employeeService.findAllByDepartment(department), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
