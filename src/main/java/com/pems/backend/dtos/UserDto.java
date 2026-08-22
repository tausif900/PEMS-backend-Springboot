package com.pems.backend.dtos;

import com.pems.backend.entity.Department;
import com.pems.backend.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Integer userId;

	@Size(min = 2, max = 60)
	@NotNull(message = "username can't be null")
	@NotBlank(message = "username can't be blank")
	private String name;

	@Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
	private String email;

	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Pattern(regexp = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$")
	private String password;

//	Many Users belongs to one Department
	private Department department;
}
