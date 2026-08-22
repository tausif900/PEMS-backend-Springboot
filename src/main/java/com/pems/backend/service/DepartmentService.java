package com.pems.backend.service;

import java.util.List;

import com.pems.backend.dtos.DepartmentDto;

public interface DepartmentService {

	DepartmentDto addDepartment(DepartmentDto departmentDto);

	List<DepartmentDto> getDepartments();
}
