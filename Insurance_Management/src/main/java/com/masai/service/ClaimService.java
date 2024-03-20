package com.masai.service;

import java.util.List;

import com.masai.model.Claim;

public interface ClaimService {
	List<Claim> getAllClaims();
    Claim getClaimById(Long claimId);
    Claim createClaim(Claim claim);
    Claim updateClaim(Long claimId, Claim claimDetails);
    void deleteClaim(Long claimId);
    List<Claim> getClaimsByStatus(String status);
    List<Claim> getClaimsForPolicy(Long policyId);
}
