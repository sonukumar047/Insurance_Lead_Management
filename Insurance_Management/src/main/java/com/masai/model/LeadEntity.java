package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class LeadEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    
    @Enumerated(EnumType.STRING)
    private LeadStatus status;
}
