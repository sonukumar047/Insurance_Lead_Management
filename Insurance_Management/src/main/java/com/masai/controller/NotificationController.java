package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Notification;
import com.masai.service.NotificationService;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@PostMapping(value = "/add-notification")
	public ResponseEntity<Notification> addNotification(@RequestBody Notification notification){
		return new ResponseEntity<Notification>(notificationService.createNotification(notification), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get-notification-by-id/{notificationId}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable("notificationId") Long notificationId){
		return new ResponseEntity<Notification>(notificationService.getNotificationById(notificationId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-all-notifications")
	public ResponseEntity<List<Notification>> getAllNotifications(){
		return new ResponseEntity<List<Notification>>(notificationService.getAllNotifications(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/update-notification/{notificationId}")
	public ResponseEntity<Notification> updateNotification(@PathVariable("notificationId") Long notificationId, @RequestBody Notification notification){
		return new ResponseEntity<Notification>(notificationService.updateNotification(notificationId, notification), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete-notification/{notificationId}")
	public ResponseEntity<String> deleteNotification(@PathVariable("notificationId") Long notificationId){
		return new ResponseEntity<String>(notificationService.deleteNotification(notificationId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-unread-notifications/{userId}")
	public ResponseEntity<List<Notification>> getUnreadNotificationsForUser(@PathVariable("userId") Long userId){
		return new ResponseEntity<List<Notification>>(notificationService.getUnreadNotificationsForUser(userId), HttpStatus.ACCEPTED);
	}
}
