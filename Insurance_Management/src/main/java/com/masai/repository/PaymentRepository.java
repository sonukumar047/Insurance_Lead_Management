package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{


//	List<Payment> findByPolicyId(Long policyId);
}
