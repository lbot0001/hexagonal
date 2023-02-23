package br.com.botton.hexagonal.application.ports.in;

import br.com.botton.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
	
	Customer find(String id);

}
