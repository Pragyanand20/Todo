package com.example.todo.dao;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// @Pattern(regexp = "^[a-zA-Z0-9]$", message = "please enter valid charactor")
	// @Pattern(regexp = "^[a-zA-Z]{6,12}$", message = "username must be of 6 to
	// 12")
	private String work;
	@Min(value = 0, message = "min priority is 0")
	@Max(value = 10, message = "max priority is 10")
	private int priority;
	private LocalDate creationTime = LocalDate.now();
	@FutureOrPresent
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	// @DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate lastDate;

	private String status = "panding";
}
