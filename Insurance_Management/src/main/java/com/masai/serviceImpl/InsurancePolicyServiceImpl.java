package com.masai.serviceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.InsurancePolicyNotFoundException;
import com.masai.model.InsurancePolicy;
import com.masai.repository.InsurancePolicyRepository;
import com.masai.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;

	@Override
	public List<InsurancePolicy> getAllInsurancePolicies() {
		return insurancePolicyRepository.findAll();
	}

	@Override
	public InsurancePolicy getInsurancePolicyById(Long policyId) {
		return insurancePolicyRepository.findById(policyId)
				.orElseThrow(() -> new InsurancePolicyNotFoundException("InsurancePolicy not found with id: " + policyId));
	}

	@Override
	public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}

	@Override
	public InsurancePolicy updateInsurancePolicy(Long policyId, InsurancePolicy policyDetails) {
		InsurancePolicy insurancePolicy = getInsurancePolicyById(policyId);
		insurancePolicy.setClaims(policyDetails.getClaims());
		insurancePolicy.setCoverageAmount(policyDetails.getCoverageAmount());
		insurancePolicy.setEndDate(policyDetails.getEndDate());
		insurancePolicy.setPolicyNumber(policyDetails.getPolicyNumber());
		insurancePolicy.setPremiumAmount(policyDetails.getPremiumAmount());
		insurancePolicy.setStatus(policyDetails.getStatus());
		insurancePolicy.setType(policyDetails.getType());
		return insurancePolicyRepository.save(insurancePolicy);
		
	}

	@Override
	public String deleteInsurancePolicy(Long policyId) {
		insurancePolicyRepository.deleteById(policyId);
		return "Insurance policy with id " + policyId + " has been deleted.";
	}

	@Override
	public List<InsurancePolicy> getPoliciesByStatus(String status) {
		return insurancePolicyRepository.findByStatus(status);
	}

	@Override
	public List<InsurancePolicy> getPoliciesExpiringBefore(LocalDate date) {
		return insurancePolicyRepository.findByEndDateBefore(date);
	}

	@Override
	public Double calculatePremium(InsurancePolicy policy) {
		Double basePremium = 0.0;
	    
	    // Calculate base premium based on coverage amount and policy type
	    switch (policy.getType()) {
	        case LIFE:
	            basePremium = policy.getCoverageAmount() * 0.02; // 2% of coverage amount
	            break;
	        case HEALTH:
	            basePremium = policy.getCoverageAmount() * 0.03; // 3% of coverage amount
	            break;
	        case AUTO:
	            basePremium = policy.getCoverageAmount() * 0.04; // 4% of coverage amount
	            break;
	        case HOME:
	            basePremium = policy.getCoverageAmount() * 0.015; // 1.5% of coverage amount
	            break;
	    }
	    
	    // Calculate additional premium based on duration
	    LocalDate currentDate = LocalDate.now();
	    long months = ChronoUnit.MONTHS.between(currentDate, policy.getEndDate());
	    Double additionalPremium = basePremium * (months / 12.0); // Assume 1 year is 12 months
	    
	    // Total premium is the sum of base premium and additional premium
	    return basePremium + additionalPremium;
	}

}
