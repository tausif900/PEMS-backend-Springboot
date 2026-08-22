package com.pems.backend.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.DepartmentDto;
import com.pems.backend.entity.Department;
import com.pems.backend.repositoriy.DepartmentRepository;
import com.pems.backend.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		department.setDepartmentName(departmentDto.getDepartmentName());
		Department savedDepartment = departmentRepository.save(department);
		DepartmentDto departmentDto2 = modelMapper.map(savedDepartment, DepartmentDto.class);
		return departmentDto2;
	}

	@Override
	public List<DepartmentDto> getDepartments() {
		List<Department> list = departmentRepository.findAll();
		List<DepartmentDto> responseDto = list.stream().map((d) -> {
			DepartmentDto departmentDto = modelMapper.map(d, DepartmentDto.class);
			return departmentDto;
		}).toList();
		return responseDto;
	}

}
