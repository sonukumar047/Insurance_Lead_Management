package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Claim;
import com.masai.model.ClaimStatus;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	List<Claim> findByStatus(String status);
	
	@Query("SELECT c FROM Claim c WHERE c.policy.policyId = :policyId")
    List<Claim> findByPolicyId(Long policyId);
	
}
