package com.masai.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	List<UserProfile> findByUsernameContainingIgnoreCase(String keyword);
    List<UserProfile> findByRole(String role);
    List<UserProfile> findByCreatedAtAfter(LocalDate date);

}
