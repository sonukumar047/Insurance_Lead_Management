package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Feedback {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;
    private LocalDateTime feedbackDateTime = LocalDateTime.now();
    private Integer rating;
    private String comments;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;
}
