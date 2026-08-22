package com.pems.backend.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.UserDto;
import com.pems.backend.entity.Department;
import com.pems.backend.entity.User;
import com.pems.backend.repositoriy.DepartmentRepository;
import com.pems.backend.repositoriy.UserRepository;
import com.pems.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto registerUser(UserDto userDto) {
		String password = passwordEncoder.encode(userDto.getPassword());
		userDto.setPassword(password);
		User user = modelMapper.map(userDto, User.class);
		Department department = departmentRepository.findById(userDto.getDepartment().getDepartmentId())
				.orElseThrow(() -> new RuntimeException("departmentId not found"));
		user.setDepartment(department);
		User savedUser = userRepository.save(user);
		UserDto responseDto = modelMapper.map(savedUser, UserDto.class);
		return responseDto;
	}

}
