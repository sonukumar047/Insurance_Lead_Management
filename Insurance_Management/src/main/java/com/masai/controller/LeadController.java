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

import com.masai.model.LeadEntity;
import com.masai.service.LeadEntityService;

@RestController
@RequestMapping(value = "/lead")
public class LeadController {

	@Autowired
	private LeadEntityService leadService;
	
	@PostMapping(value = "/create-lead")
	public ResponseEntity<LeadEntity> createLead(@RequestBody LeadEntity lead){
		return new ResponseEntity<LeadEntity>(leadService.createLead(lead), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get-lead-by-id/{leadId}")
	public ResponseEntity<LeadEntity> getLeadById(@PathVariable("leadId") Long leadId){
		return new ResponseEntity<LeadEntity>(leadService.getLeadById(leadId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-all-lads")
	public ResponseEntity<List<LeadEntity>> getAllLeads(){
		return new ResponseEntity<List<LeadEntity>>(leadService.getAllLeads(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/update-lead/{leadId}")
	public ResponseEntity<LeadEntity> updateLead(@PathVariable("leadId") Long leadId, @RequestBody LeadEntity lead){
		return new ResponseEntity<LeadEntity>(leadService.updateLead(leadId, lead), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete-lead/{leadId}")
	public ResponseEntity<String> deleteLead(@PathVariable("leadId") Long leadId){
		return new ResponseEntity<String>(leadService.deleteLead(leadId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-leads-by-status/{status}")
	public ResponseEntity<List<LeadEntity>> getLeadsByStatus(@PathVariable("status") String status){
		return new ResponseEntity<List<LeadEntity>>(leadService.getLeadsByStatus(status), HttpStatus.ACCEPTED);
	}
}
