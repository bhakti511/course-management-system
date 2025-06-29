package com.bhakti.courseapp.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhakti.courseapp.entities.User;
import com.bhakti.courseapp.exceptions.ResourceNotFoundException;
import com.bhakti.courseapp.payloads.UserDto;
import com.bhakti.courseapp.repositories.UserRepo;
import com.bhakti.courseapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto user) {
		User savedUser = userRepo.save(userDtoToUser(user));
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer id) {

		User userFound = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		userFound.setName(user.getName());
		userFound.setEmail(user.getEmail());
		userFound.setPassword(user.getPassword());

		User updatedUserUser = userRepo.save(userFound);

		return this.userToUserDto(updatedUserUser);
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		List<User> users =  userRepo.findAll();
		for (User user : users) {
			userDtos.add(userToUserDto(user));
		}
		return userDtos;
	}

	@Override
	public void deleteUserByUserId(Integer id) {
		
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		userRepo.delete(user);

	}
	
	private User userDtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
		
	}
	
	private UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
