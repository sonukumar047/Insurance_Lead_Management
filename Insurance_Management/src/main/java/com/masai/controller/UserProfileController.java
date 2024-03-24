package com.masai.controller;

import java.time.LocalDate;
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

import com.masai.model.UserProfile;
import com.masai.service.UserProfileService;

@RestController
@RequestMapping(value = "/user")
public class UserProfileController {

	@Autowired
	private UserProfileService userService;
	
	@PostMapping(value = "/add-user")
	public ResponseEntity<UserProfile> addUserProfile(@RequestBody UserProfile user){
		return new ResponseEntity<UserProfile>(userService.createUserProfile(user), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get-user-by-id/{userId}")
	public ResponseEntity<UserProfile> getUserProfileById(@PathVariable("userId") Long userId){
		return new ResponseEntity<UserProfile>(userService.getUserProfileById(userId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-all-users")
	public ResponseEntity<List<UserProfile>> getAllUsersProfile(){
		return new ResponseEntity<List<UserProfile>>(userService.getAllUsersProfile(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/update-user/{userId}")
	public ResponseEntity<UserProfile> updateUserProfile(@PathVariable("userId") Long userId, @RequestBody UserProfile user){
		return new ResponseEntity<UserProfile>(userService.updateUserProfile(userId, user), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete-user/{userId}")
	public ResponseEntity<String> deleteUserProfile(@PathVariable("userId") Long userId){
		return new ResponseEntity<String>(userService.deleteUserProfile(userId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/search-users/{keyword}")
	public ResponseEntity<List<UserProfile>> searchUsers(@PathVariable("keyword") String keyword){
		return new ResponseEntity<List<UserProfile>>(userService.searchUsers(keyword), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-users-by-rolr/{role}")
	public ResponseEntity<List<UserProfile>> getUsersProfileByRole(@PathVariable("role") String role){
		return new ResponseEntity<List<UserProfile>>(userService.getUsersProfileByRole(role), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-users-created-after/{date}")
	public ResponseEntity<List<UserProfile>> getUsersCreatedAfter(@PathVariable("date") LocalDate date){
		return new ResponseEntity<List<UserProfile>>(userService.getUsersCreatedAfter(date), HttpStatus.ACCEPTED);
	}
}
