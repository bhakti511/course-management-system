package com.bhakti.courseapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhakti.courseapp.payloads.ApiResponse;
import com.bhakti.courseapp.payloads.UserDto;
import com.bhakti.courseapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {

		UserDto userDto = userService.createUser(user);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}

	// Update User
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable("id") int id) {
		UserDto updatedUser = userService.updateUser(user, id);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int uid) {
		userService.deleteUserByUserId(uid);
		return new ResponseEntity<>(new ApiResponse("User deleted successfully...", true), HttpStatus.OK);
	}

	// Get User
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") int id) {

		UserDto userDto = userService.getUserById(id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	// Get User
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

}
