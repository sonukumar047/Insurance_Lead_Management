package com.masai.service;

import java.util.List;

import com.masai.model.Notification;

public interface NotificationService {
	List<Notification> getAllNotifications();
    Notification getNotificationById(Long notificationId);
    Notification createNotification(Notification notification);
    Notification updateNotification(Long notificationId, Notification notificationDetails);
    String deleteNotification(Long notificationId);
    List<Notification> getUnreadNotificationsForUser(Long userId);
}
