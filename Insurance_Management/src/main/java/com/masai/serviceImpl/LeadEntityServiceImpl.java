package com.masai.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LeadEntityNotFoundException;
import com.masai.model.LeadEntity;
import com.masai.repository.LeadEntityRepository;
import com.masai.service.LeadEntityService;

@Service
public class LeadEntityServiceImpl implements LeadEntityService {
	
	@Autowired
	private LeadEntityRepository leadEntityRepository;

	@Override
	public List<LeadEntity> getAllLeads() {
		return leadEntityRepository.findAll();
	}

	@Override
	public LeadEntity getLeadById(Long leadId) {
		return leadEntityRepository.findById(leadId)
				.orElseThrow(() -> new LeadEntityNotFoundException("Lead not found with id: " + leadId));
	}

	@Override
	public LeadEntity createLead(LeadEntity lead) {
		return leadEntityRepository.save(lead);
	}

	@Override
	public LeadEntity updateLead(Long leadId, LeadEntity leadDetails) {
		LeadEntity lead = getLeadById(leadId);
		lead.setFirstName(leadDetails.getFirstName());
		lead.setLastName(leadDetails.getLastName());
		lead.setEmail(leadDetails.getEmail());
		lead.setPhone(leadDetails.getPhone());
		lead.setStatus(leadDetails.getStatus());
		return leadEntityRepository.save(lead);
	}

	@Override
	public String deleteLead(Long leadId) {
		leadEntityRepository.deleteById(leadId);
		return "Lead deleted with Id :"+ leadId + "Successfully";
	}

	@Override
	public List<LeadEntity> getLeadsByStatus(String status) {
		return leadEntityRepository.findByStatus(status);
	}

}
