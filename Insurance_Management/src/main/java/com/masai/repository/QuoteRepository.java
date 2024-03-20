package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
	
//	List<Quote> findByPolicyId(Long policyId);

}
