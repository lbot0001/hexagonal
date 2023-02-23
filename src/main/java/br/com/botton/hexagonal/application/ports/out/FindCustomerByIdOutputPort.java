package br.com.botton.hexagonal.application.ports.out;

import java.util.Optional;

import br.com.botton.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {
	
	Optional<Customer> find(String id);

}
