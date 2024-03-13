package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Double commissionRate;
}
