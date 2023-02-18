package br.com.botton.hexagonal.adapters.out.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class CustomerEntity {
	
	private String id;
	private String name;
	private AddressEntity address;
	private String cpf;
	private Boolean isValid;

}
