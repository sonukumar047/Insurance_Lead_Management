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

import com.masai.model.Claim;
import com.masai.service.ClaimService;

@RestController
@RequestMapping(value = "/claim")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@PostMapping(value = "/addClaim")
	public ResponseEntity<Claim> addClaim(@RequestBody Claim clain){
		return new ResponseEntity<Claim>(claimService.createClaim(clain), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getClaimById/{claimId}")
	public ResponseEntity<Claim> getClaimById(@PathVariable("claimId") Long claimId){
		return new ResponseEntity<Claim>(claimService.getClaimById(claimId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "getAllClaims")
	public ResponseEntity<List<Claim>> getAllClaims(){
		return new ResponseEntity<List<Claim>>(claimService.getAllClaims(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateClaim/{claimId}")
	public ResponseEntity<Claim> updateClaim(@PathVariable("claimId") Long claimId, @RequestBody Claim claim){
		return new ResponseEntity<Claim>(claimService.updateClaim(claimId, claim), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteClaim/{claimId}")
	public ResponseEntity<String> deleteClaim(@PathVariable("claimId") Long claimId){
		return new ResponseEntity<String>(claimService.deleteClaim(claimId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getClaimsByStatus/{status}")
	public ResponseEntity<List<Claim>> getClaimsByStatus(@PathVariable("status") String status){
		return new ResponseEntity<List<Claim>>(claimService.getClaimsByStatus(status), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getClaimsForPolicy/{policyId}")
	public ResponseEntity<List<Claim>> getClaimsForPolicy(@PathVariable("policyId") Long policyId){
		return new ResponseEntity<List<Claim>>(claimService.getClaimsForPolicy(policyId), HttpStatus.ACCEPTED);
	}
}
