package br.com.botton.hexagonal.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.botton.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.botton.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

	CustomerEntity toCustomerEntity(Customer customer);
	
}
