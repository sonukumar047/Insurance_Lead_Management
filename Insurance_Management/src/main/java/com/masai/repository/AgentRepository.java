package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
