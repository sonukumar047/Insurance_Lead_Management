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

import com.masai.model.Feedback;
import com.masai.service.FeedbackService;

@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping(value = "/addFeedback")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
		return new ResponseEntity<Feedback>(feedbackService.createFeedback(feedback), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getFeedbackById/{feedbackId}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("feedbackId") Long feedbackId){
		return new ResponseEntity<Feedback>(feedbackService.getFeedbackById(feedbackId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getAllFeedback")
	public ResponseEntity<List<Feedback>> getAllFeedbacks(){
		return new ResponseEntity<List<Feedback>>(feedbackService.getAllFeedbacks(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateFeedback/{feedbackId}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable("feedbackId") Long feedbackId, @RequestBody Feedback feedback){
		return new ResponseEntity<Feedback>(feedbackService.updateFeedback(feedbackId, feedback), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/deleteFeedback/{feedbackId}")
	public ResponseEntity<String> deleteFeedback(@PathVariable("feedbackId") Long feedbackId){
		return new ResponseEntity<String>(feedbackService.deleteFeedback(feedbackId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFeedbacksByRating/{rating}")
	public ResponseEntity<List<Feedback>> getFeedbacksByRating(@PathVariable("rating") int rating){
		return new ResponseEntity<List<Feedback>>(feedbackService.getFeedbacksByRating(rating), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "getFeedbacksByUser/{userId}")
	public ResponseEntity<List<Feedback>> getFeedbacksByUser(@PathVariable("userId") Long userId){
		return new ResponseEntity<List<Feedback>>(feedbackService.getFeedbacksByUser(userId), HttpStatus.ACCEPTED);
	}
}
