package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
