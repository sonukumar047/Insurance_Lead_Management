package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.model.UserProfile;

public interface UserProfileService {
	List<UserProfile> getAllUsersProfile();
	UserProfile getUserProfileById(Long userId);
	UserProfile createUserProfile(UserProfile userProfile);
	UserProfile updateUserProfile(Long userId, UserProfile userProfile);
	String deleteUserProfile(Long userId);
	List<UserProfile> searchUsers(String keyword);
	List<UserProfile> getUsersProfileByRole(String role);
	List<UserProfile> getUsersCreatedAfter(LocalDate date);
	
}
