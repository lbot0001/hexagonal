package br.com.botton.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import br.com.botton.hexagonal.adapters.out.client.response.AddressResponse;
import br.com.botton.hexagonal.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

	Address toAddress(AddressResponse addressResponse);
	
}
