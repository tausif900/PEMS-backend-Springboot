package com.pems.backend.dtos;

import java.util.List;

import com.pems.backend.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

	private Integer departmentId;

	private String departmentName;

//	One Department will have list of Users
	private List<User> users;
}
