package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Advertisement {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertisementId;

    private String title;
    private String content;
    private LocalDateTime startDateTime = LocalDateTime.now();
    private LocalDate endDate;

}
