package com.masai.service;

import java.util.List;

import com.masai.model.Payment;

public interface PaymentService {
	List<Payment> getAllPayments();
    Payment getPaymentById(Long paymentId);
    Payment createPayment(Payment payment);
    Payment updatePayment(Long paymentId, Payment paymentDetails);
    String deletePayment(Long paymentId);
    List<Payment> getPaymentsForPolicy(Long policyId);
    Double getTotalPaymentsForPolicy(Long policyId);
}
