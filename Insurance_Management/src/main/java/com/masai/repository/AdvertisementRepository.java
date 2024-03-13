package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
