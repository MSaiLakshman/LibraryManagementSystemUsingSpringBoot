package com.lms.library_management_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String title;
	private String author;
	private boolean borrowed;
	private LocalDateTime borrowedTime;
	private LocalDateTime returnTime;
	@ManyToOne
	private User user;
}
