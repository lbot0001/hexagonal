package br.com.botton.hexagonal.application.ports.in;

import br.com.botton.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
	
	void update(Customer customer, String zipCode);
	

}
