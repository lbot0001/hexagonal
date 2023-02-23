package br.com.botton.hexagonal.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.botton.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.botton.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.botton.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	//nesse caso existem campos no Customer que nao existem no request, precisa tratar (ignorar) isso
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "address", ignore = true)
	@Mapping(target = "isValidCpf", ignore = true)
	Customer toCustomer(CustomerRequest customerRequest);
	
	CustomerResponse toCustomerResponse(Customer customer);
}
