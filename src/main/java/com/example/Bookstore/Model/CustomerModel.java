package com.example.Bookstore.Model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "custumers")
@Table(name = "custumers")
@SQLDelete(sql = "UPDATE custumers SET deleted = true, updated_at = now() WHERE id = ?")
@Where(clause = "deleted = false")
public class CustomerModel extends RepresentationModel<CustomerModel> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name", updatable = false)
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@CPF
	@Column(name = "cpf", unique = true, updatable = false)
	private String cpf;
	
	@Column(name = "phone", unique = true)
	private String phone;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "overdue")
	private boolean overdue;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isOverdue() {
		return overdue;
	}
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}
	
	
}
