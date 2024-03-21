package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.model.InsurancePolicy;
import com.masai.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
	
	@Query("SELECT q FROM Quote q WHERE q.policy.policyId = :policyId")
	List<Quote> findByPolicyId(Long policyId);

}
