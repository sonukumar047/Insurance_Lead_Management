package com.masai.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NotificationNotFoundException;
import com.masai.model.Notification;
import com.masai.repository.NotificationRepository;
import com.masai.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

	@Override
	public Notification getNotificationById(Long notificationId) {
		return notificationRepository.findById(notificationId)
				.orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + notificationId));
	}

	@Override
	public Notification createNotification(Notification notification) {
		return notificationRepository.save(notification);
	}

	@Override
	public Notification updateNotification(Long notificationId, Notification notificationDetails) {
		Notification notification = getNotificationById(notificationId);
		notification.setMessage(notificationDetails.getMessage());
		notification.setReadStatus(notificationDetails.getReadStatus());
		notification.setReadStatus(notificationDetails.getReadStatus());
		return notificationRepository.save(notification);
	}

	@Override
	public String deleteNotification(Long notificationId) {
		notificationRepository.deleteById(notificationId);
		return "Notification deleted with Id :" + notificationId + "Successfully";
	}

	@Override
	public List<Notification> getUnreadNotificationsForUser(Long userId) {
		return notificationRepository.findUnreadNotificationsForUser(userId);
	}

}
