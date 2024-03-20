package com.masai.service;

import java.util.List;

import com.masai.model.LeadEntity;

public interface LeadEntityService {
	List<LeadEntity> getAllLeads();
	LeadEntity getLeadById(Long leadId);
	LeadEntity createLead(LeadEntity lead);
	LeadEntity updateLead(Long leadId, LeadEntity leadDetails);
    String deleteLead(Long leadId);
    List<LeadEntity> getLeadsByStatus(String status);

}
