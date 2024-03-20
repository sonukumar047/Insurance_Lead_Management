package com.masai.service;

import java.util.List;

import com.masai.model.Agent;

public interface AgentService {
	List<Agent> getAllAgents();
    Agent getAgentById(Long agentId);
    Agent createAgent(Agent agent);
    Agent updateAgent(Long agentId, Agent agentDetails);
    String deleteAgent(Long agentId);
    List<Agent> getTopAgentsBySales(int limit);
    List<Agent> getAgentsWithCommissionAbove(Double commissionRate);

}
