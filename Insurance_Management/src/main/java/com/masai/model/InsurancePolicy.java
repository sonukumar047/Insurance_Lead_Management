package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	private String policyNumber;
	
	@Enumerated(EnumType.STRING)
    private PolicyType type;
	
    private Double coverageAmount;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;
    private Double premiumAmount;
    
    @Enumerated(EnumType.STRING)
    private PolicyStatus status;
    
    @JsonIgnore
    @OneToMany(mappedBy = "policy")
    private List<Claim> claims;
    
    @JsonIgnore
    @OneToMany(mappedBy = "policy")
    private List<Payment> payments;
}
