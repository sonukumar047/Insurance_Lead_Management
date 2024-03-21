package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	@Query("SELECT p FROM Payment p WHERE p.policy.policyId = :policyId")
    List<Payment> findByPolicyId(Long policyId);
	
	@Query("SELECT SUM(p.amount) FROM Payment p WHERE p.policy.policyId = :policyId")
    Double getTotalPaymentsForPolicy(Long policyId);
}
