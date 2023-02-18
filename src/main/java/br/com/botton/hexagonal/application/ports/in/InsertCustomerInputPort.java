package br.com.botton.hexagonal.application.ports.in;

import br.com.botton.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

	void insert(Customer customer, String zipCode);
	
}
