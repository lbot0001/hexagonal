package br.com.botton.hexagonal.application.ports.out;

import br.com.botton.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
	
	void update(Customer customer);

}
