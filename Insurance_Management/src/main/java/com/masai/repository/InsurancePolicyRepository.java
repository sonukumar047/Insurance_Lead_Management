package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

	List<InsurancePolicy> findByStatus(String status);
    List<InsurancePolicy> findByEndDateBefore(LocalDate date);
}
