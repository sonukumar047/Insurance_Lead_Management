package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AdvertisementNotFoundException.class)
	public ResponseEntity<ExceptionDefination> advertisementNotFound(AdvertisementNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AgentNotFoundException.class)
	public ResponseEntity<ExceptionDefination> agentNotFound(AgentNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ClaimNotFoundException.class)
	public ResponseEntity<ExceptionDefination> claimNotFound(ClaimNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<ExceptionDefination> feedbackNotFound(FeedbackNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsurancePolicyNotFoundException.class)
	public ResponseEntity<ExceptionDefination> insurancePolicyNotFound(InsurancePolicyNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LeadEntityNotFoundException.class)
	public ResponseEntity<ExceptionDefination> leadEntityNotFound(LeadEntityNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotificationNotFoundException.class)
	public ResponseEntity<ExceptionDefination> notificationNotFound(NotificationNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ExceptionDefination> paymentNotFound(PaymentNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(QuoteNotFoundException.class)
	public ResponseEntity<ExceptionDefination> quoteNotFound(QuoteNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserProfileNotFoundException.class)
	public ResponseEntity<ExceptionDefination> userProfileNotFound(UserProfileNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDefination> globalExceptionHandler(Exception ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefination>(
				new ExceptionDefination(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND);
	}
	
}
