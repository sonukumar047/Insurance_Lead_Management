package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

//	List<Notification> findByReadStatusFalseAndUserId(Long userId);
}
