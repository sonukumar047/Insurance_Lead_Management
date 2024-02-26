package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;
    private LocalDateTime claimDateTime = LocalDateTime.now();
    private Double amount;
    
    @Enumerated(EnumType.STRING)
    private ClaimStatus status;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy policy;

}
