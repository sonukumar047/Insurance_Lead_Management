package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
