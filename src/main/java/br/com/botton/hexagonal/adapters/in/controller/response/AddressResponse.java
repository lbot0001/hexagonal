package br.com.botton.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data //aqui pode ter framework, nao estamos no core
public class AddressResponse {

	private String street;
	private String city;
	private String state;

}
