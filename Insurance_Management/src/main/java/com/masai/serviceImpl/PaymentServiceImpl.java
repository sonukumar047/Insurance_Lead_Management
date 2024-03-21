package com.masai.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PaymentNotFoundException;
import com.masai.model.Payment;
import com.masai.repository.PaymentRepository;
import com.masai.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Long paymentId) {
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + paymentId));
	}

	@Override
	public Payment createPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment updatePayment(Long paymentId, Payment paymentDetails) {
		Payment payment = getPaymentById(paymentId);
		payment.setAmount(paymentDetails.getAmount());
		payment.setPolicy(paymentDetails.getPolicy());
		return paymentRepository.save(payment);
	}

	@Override
	public String deletePayment(Long paymentId) {
		paymentRepository.deleteById(paymentId);
		return "Payment deleted successfully";
	}

	@Override
	public List<Payment> getPaymentsForPolicy(Long policyId) {
		return paymentRepository.findByPolicyId(policyId);
	}

	@Override
	public Double getTotalPaymentsForPolicy(Long policyId) {
		return paymentRepository.getTotalPaymentsForPolicy(policyId);
	}

}
