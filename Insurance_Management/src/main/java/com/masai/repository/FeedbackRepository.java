package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	List<Feedback> findByRating(int rating);
	
	@Query("SELECT f FROM Feedback f WHERE f.user.userId = :userId")
	List<Feedback> findByUserId(Long userId);
}
