package com.masai.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.InsurancePolicy;
import com.masai.service.InsurancePolicyService;

@RestController
@RequestMapping(value = "/insurancePolicy")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	@PostMapping(value = "/addPolicy")
	public ResponseEntity<InsurancePolicy> addInsurancePolicy(@RequestBody InsurancePolicy policy){
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.createInsurancePolicy(policy), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getPolicyById/{policyId}")
	public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable("policyId") Long policyId){
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.getInsurancePolicyById(policyId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getAllPolicyes")
	public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicyes(){
		return new ResponseEntity<List<InsurancePolicy>>(insurancePolicyService.getAllInsurancePolicies(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updatePolicy/{policyId}")
	public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable("policyId") Long policyId, @RequestBody InsurancePolicy policy){
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.updateInsurancePolicy(policyId, policy), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/deletePolicy/{policyId}")
	public ResponseEntity<String> deleteInsurancePolicy(@PathVariable("policyId") Long policyId){
		return new ResponseEntity<String>(insurancePolicyService.deleteInsurancePolicy(policyId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPoliciesByStatus/{status}")
	public ResponseEntity<List<InsurancePolicy>> getPoliciesByStatus(@PathVariable("status") String status){
		return new ResponseEntity<List<InsurancePolicy>>(insurancePolicyService.getPoliciesByStatus(status), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getPoliciesExpiringBefore/{date}")
	public ResponseEntity<List<InsurancePolicy>> getPoliciesExpiringBefore(@PathVariable("date") LocalDate date){
		return new ResponseEntity<List<InsurancePolicy>>(insurancePolicyService.getPoliciesExpiringBefore(date), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/calculate-premium/{policyId}")
	public ResponseEntity<Double> calculatePremium(@PathVariable("policyId") Long policyId){
		InsurancePolicy policy = insurancePolicyService.getInsurancePolicyById(policyId);
		return new ResponseEntity<Double>(insurancePolicyService.calculatePremium(policy), HttpStatus.OK);
	}
}
