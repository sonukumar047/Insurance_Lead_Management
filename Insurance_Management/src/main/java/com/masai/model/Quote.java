package com.masai.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
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
public class Quote {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteId;
    private Double quotedAmount;
    private LocalDate expirationDate;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy policy;
}
