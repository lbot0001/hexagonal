package br.com.botton.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.botton.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.botton.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

}
