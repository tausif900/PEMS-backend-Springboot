package com.pems.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.DepartmentDto;
import com.pems.backend.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/add-department")
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto department = departmentService.addDepartment(departmentDto);
		return new ResponseEntity<DepartmentDto>(department, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<DepartmentDto>> getDepartments() {
		return ResponseEntity.ok(departmentService.getDepartments());
	}
}
