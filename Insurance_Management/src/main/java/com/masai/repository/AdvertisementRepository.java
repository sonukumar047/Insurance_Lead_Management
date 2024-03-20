package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

	List<Advertisement> findByEndDateAfter(LocalDate date);
}
