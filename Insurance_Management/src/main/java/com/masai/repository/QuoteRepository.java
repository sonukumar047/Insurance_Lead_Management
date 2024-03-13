package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
