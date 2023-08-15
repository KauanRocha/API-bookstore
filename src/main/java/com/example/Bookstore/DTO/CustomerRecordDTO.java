package com.example.Bookstore.DTO;

import jakarta.validation.constraints.NotBlank;

public record CustomerRecordDTO(@NotBlank String firstName,@NotBlank String cpf,@NotBlank String phone,@NotBlank String email, boolean overdue) {
	
	
}
