package com.masai.service;

import java.util.List;

import com.masai.model.Feedback;

public interface FeedbackService {
	List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long feedbackId);
    Feedback createFeedback(Feedback feedback);
    Feedback updateFeedback(Long feedbackId, Feedback feedbackDetails);
    String deleteFeedback(Long feedbackId);
    List<Feedback> getFeedbacksByRating(int rating);
    List<Feedback> getFeedbacksByUser(Long userId);
}
