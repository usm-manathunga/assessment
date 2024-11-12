package com.grizer.assessment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@ToString
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String first_name;
	private String last_name;

	@Column(unique = true)
	private String email;

	private String phone;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;

}
