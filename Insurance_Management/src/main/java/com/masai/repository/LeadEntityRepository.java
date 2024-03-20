package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.LeadEntity;

public interface LeadEntityRepository extends JpaRepository<LeadEntity, Long> {

	List<LeadEntity> findByStatus(String status);
}
