package com.masai.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ClaimNotFoundException;
import com.masai.model.Claim;
import com.masai.repository.ClaimRepository;
import com.masai.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	private ClaimRepository claimRepository;

	@Override
	public List<Claim> getAllClaims() {
		return claimRepository.findAll();
	}

	@Override
	public Claim getClaimById(Long claimId) {
		return claimRepository.findById(claimId)
				.orElseThrow(() -> new ClaimNotFoundException("Claim not found with id: " + claimId));
	}

	@Override
	public Claim createClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public Claim updateClaim(Long claimId, Claim claimDetails) {
		Claim claim = getClaimById(claimId);
		claim.setAmount(claimDetails.getAmount());
		claim.setPolicy(claimDetails.getPolicy());
		claim.setStatus(claimDetails.getStatus());
		return claimRepository.save(claim);
	}

	@Override
	public String deleteClaim(Long claimId) {
		claimRepository.deleteById(claimId);
		return "Claim deleted successfully";
	}

	@Override
	public List<Claim> getClaimsByStatus(String status) {
		return claimRepository.findByStatus(status);
	}

	@Override
	public List<Claim> getClaimsForPolicy(Long policyId) {
		return claimRepository.findByPolicyId(policyId);
	}

}
