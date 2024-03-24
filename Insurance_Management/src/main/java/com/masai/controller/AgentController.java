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

import com.masai.model.Agent;
import com.masai.service.AgentService;

@RestController
@RequestMapping(value = "/agent")
public class AgentController {

	@Autowired
	private AgentService agentService;
	
	@PostMapping(value = "/addAgent")
	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent){
		return new ResponseEntity<Agent>(agentService.createAgent(agent), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAgentById/{agentId}")
	public ResponseEntity<Agent> getAgentById(@PathVariable("agentId") Long agentId){
		return new ResponseEntity<Agent>(agentService.getAgentById(agentId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getAllAgents")
	public ResponseEntity<List<Agent>> getAllAgents(){
		return new ResponseEntity<List<Agent>>(agentService.getAllAgents(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateAgent/{agentId}")
	public ResponseEntity<Agent> updateAgent(@PathVariable("agentId") Long agentId, @RequestBody Agent agent){
		return new ResponseEntity<Agent>(agentService.updateAgent(agentId, agent), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAgent/{agentId}")
	public ResponseEntity<String> deleteAgent(@PathVariable("agentId") Long agentId){
		return new ResponseEntity<String>(agentService.deleteAgent(agentId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getTopAgentsBySales/{limit}")
	public ResponseEntity<List<Agent>> getTopAgentsBySales(@PathVariable("limit") int limit){
		return new ResponseEntity<List<Agent>>(agentService.getTopAgentsBySales(limit), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getAgentsWithCommissionAbove/{commissionRate}")
	public ResponseEntity<List<Agent>> getAgentsWithCommissionAbove(@PathVariable("commissionRate") Double commissionRate){
		return new ResponseEntity<List<Agent>>(agentService.getAgentsWithCommissionAbove(commissionRate), HttpStatus.ACCEPTED);
	}
}
