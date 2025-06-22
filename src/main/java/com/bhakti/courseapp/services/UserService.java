package com.bhakti.courseapp.services;

import java.util.List;

import com.bhakti.courseapp.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUsers();
	
	void deleteUserByUserId(Integer id);
}
