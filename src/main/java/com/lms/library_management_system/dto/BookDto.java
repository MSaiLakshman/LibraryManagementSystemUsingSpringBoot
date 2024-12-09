package com.lms.library_management_system.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

	private int bookId;
	private String title;
	private String author;
	private LocalDateTime borrowedTime;
	private LocalDateTime returnTime;
	private boolean borrowed;
}
 