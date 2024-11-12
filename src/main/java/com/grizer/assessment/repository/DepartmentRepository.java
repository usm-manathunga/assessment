package com.grizer.assessment.repository;

import com.grizer.assessment.entity.Department;
import com.grizer.assessment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
;
}
