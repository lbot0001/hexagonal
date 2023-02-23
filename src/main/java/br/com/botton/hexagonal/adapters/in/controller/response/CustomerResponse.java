package br.com.botton.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data //aqui pode ter framework, nao estamos no core
public class CustomerResponse {
	
	private String name;
	private AddressResponse address;
	private String cpf;
	private Boolean isValid;

}
