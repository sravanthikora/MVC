package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class mvc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(max = 20, min = 5)
	private String name;
	
	@Email
	private String email;
	
	private String password;
}
