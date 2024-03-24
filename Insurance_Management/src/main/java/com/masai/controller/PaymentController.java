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

import com.masai.model.Payment;
import com.masai.service.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value = "/do-payment")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.createPayment(payment), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get-payment-by-id/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") Long paymentId){
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-all-payments")
	public ResponseEntity<List<Payment>> getAllPayments(){
		return new ResponseEntity<List<Payment>>(paymentService.getAllPayments(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/update-payment/{paymentId}")
	public ResponseEntity<Payment> updatePayment(@PathVariable("paymentId") Long paymentId, @RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.updatePayment(paymentId, payment), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete-payment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable("paymentId") Long paymentId){
		return new ResponseEntity<String>(paymentService.deletePayment(paymentId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-payments-for-policy/{policyId}")
	public ResponseEntity<List<Payment>> getPaymentsForPolicy(@PathVariable("policyId") Long policyId){
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentsForPolicy(policyId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-total-payments-for-policy/{policyId}")
	public ResponseEntity<Double> getTotalPaymentsForPolicy(@PathVariable("policyId") Long policyId){
		return new ResponseEntity<Double>(paymentService.getTotalPaymentsForPolicy(policyId), HttpStatus.ACCEPTED);
	}
}
