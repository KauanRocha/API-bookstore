package com.example.Bookstore.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.DTO.BooksRecordDTO;
import com.example.Bookstore.Model.CustomerModel;
import com.example.Bookstore.Repository.CustomerRepository;

import jakarta.validation.Valid;

@RestController 
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/customer")
	public ResponseEntity<CustomerModel> createCustomer(@RequestBody @Valid BooksRecordDTO booksRecordDTO){
		
		CustomerModel customerModel = new CustomerModel();
		
		BeanUtils.copyProperties(booksRecordDTO, customerModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.save(customerModel));
	}
	
	
}
