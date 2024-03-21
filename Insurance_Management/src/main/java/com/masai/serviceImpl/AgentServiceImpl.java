package com.masai.serviceImpl;

import java.util.List;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AgentNotFoundException;
import com.masai.model.Agent;
import com.masai.repository.AgentRepository;
import com.masai.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService{
	
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public List<Agent> getAllAgents() {
		return agentRepository.findAll();
	}

	@Override
	public Agent getAgentById(Long agentId) {
		return agentRepository.findById(agentId)
				.orElseThrow(() -> new AgentNotFoundException("Agent not found with id: " + agentId));
	}

	@Override
	public Agent createAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public Agent updateAgent(Long agentId, Agent agentDetails) {
		Agent agent = getAgentById(agentId);
		agent.setFirstName(agentDetails.getFirstName());
		agent.setLastName(agentDetails.getLastName());
		agent.setCommissionRate(agentDetails.getCommissionRate());
		agent.setEmail(agentDetails.getEmail());
		agent.setPhone(agentDetails.getPhone());
		return agentRepository.save(agent);
	}

	@Override
	public String deleteAgent(Long agentId) {
		agentRepository.deleteById(agentId);
		return "Agent deleted successfully";
	}

	@Override
	public List<Agent> getTopAgentsBySales(int limit) {
		List<Agent> allAgents = agentRepository.findAll();
        allAgents.sort(Comparator.comparing(Agent::getSales).reversed());
        return allAgents.subList(0, Math.min(limit, allAgents.size()));
	}

	@Override
	public List<Agent> getAgentsWithCommissionAbove(Double commissionRate) {
		return agentRepository.findByCommissionRateGreaterThan(commissionRate);
	}

}
