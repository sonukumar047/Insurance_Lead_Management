package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Claim;
import com.masai.model.ClaimStatus;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	List<Claim> findByStatus(String status);
	
}
