package com.pems.backend.service;

import com.pems.backend.dtos.UserDto;

public interface UserService {
	UserDto registerUser(UserDto userDto);
}
