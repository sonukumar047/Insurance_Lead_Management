package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.model.InsurancePolicy;

public interface InsurancePolicyService {
	List<InsurancePolicy> getAllInsurancePolicies();
	InsurancePolicy getInsurancePolicyById(Long policyId);
	InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy);
	InsurancePolicy updateInsurancePolicy(Long policyId, InsurancePolicy policyDetails);
	String deleteInsurancePolicy(Long policyId);
	List<InsurancePolicy> getPoliciesByStatus(String status);
    List<InsurancePolicy> getPoliciesExpiringBefore(LocalDate date);
    Double calculatePremium(InsurancePolicy policy);

}
