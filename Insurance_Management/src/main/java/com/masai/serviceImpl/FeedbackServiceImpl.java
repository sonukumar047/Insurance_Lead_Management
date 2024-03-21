package com.masai.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FeedbackNotFoundException;
import com.masai.model.Feedback;
import com.masai.repository.FeedbackRepository;
import com.masai.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback getFeedbackById(Long feedbackId) {
		return feedbackRepository.findById(feedbackId)
				.orElseThrow(() -> new FeedbackNotFoundException("Feedback not found with id: " + feedbackId));
	}

	@Override
	public Feedback createFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Long feedbackId, Feedback feedbackDetails) {
		Feedback feedback = getFeedbackById(feedbackId);
		feedback.setComments(feedbackDetails.getComments());
		feedback.setRating(feedbackDetails.getRating());
		return feedbackRepository.save(feedback);
	}

	@Override
	public String deleteFeedback(Long feedbackId) {
		feedbackRepository.deleteById(feedbackId);
		return "Feedback deleted successfully";
	}

	@Override
	public List<Feedback> getFeedbacksByRating(int rating) {
		return feedbackRepository.findByRating(rating);
	}

	@Override
	public List<Feedback> getFeedbacksByUser(Long userId) {
		return feedbackRepository.findByUserId(userId);
	}

}
