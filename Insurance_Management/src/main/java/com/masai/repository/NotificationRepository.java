package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	@Query("SELECT n FROM Notification n WHERE n.readStatus = false AND n.user.userId = :userId")
    List<Notification> findUnreadNotificationsForUser(Long userId);
}
