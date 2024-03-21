package com.masai.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserProfileNotFoundException;
import com.masai.model.UserProfile;
import com.masai.repository.UserProfileRepository;
import com.masai.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public List<UserProfile> getAllUsersProfile() {
		return userProfileRepository.findAll();
	}

	@Override
	public UserProfile getUserProfileById(Long userId) {
		return userProfileRepository.findById(userId)
				.orElseThrow(() -> new UserProfileNotFoundException("User not found with id: " + userId));
	}

	@Override
	public UserProfile createUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUserProfile(Long userId, UserProfile userDetails) {
		UserProfile userProfile = getUserProfileById(userId);
		userProfile.setUsername(userDetails.getUsername());
		userProfile.setPassword(userDetails.getPassword());
		userProfile.setEmail(userDetails.getEmail());
		userProfile.setRole(userDetails.getRole());
		return userProfileRepository.save(userProfile);
	}

	@Override
	public String deleteUserProfile(Long userId) {
		userProfileRepository.deleteById(userId);
		return "UserProfile deleted successfully";
	}

	@Override
	public List<UserProfile> searchUsers(String keyword) {
		return userProfileRepository.findByUsernameContainingIgnoreCase(keyword);
	}

	@Override
	public List<UserProfile> getUsersProfileByRole(String role) {
		return userProfileRepository.findByRole(role);
	}

	@Override
	public List<UserProfile> getUsersCreatedAfter(LocalDate date) {
		return userProfileRepository.findByCreatedAtAfter(date);
	}

}
