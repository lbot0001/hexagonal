package br.com.botton.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.botton.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.botton.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.botton.hexagonal.application.core.domain.Customer;
import br.com.botton.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerEntityMapper customerEntityMapper;
	
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		var customerEntity = customerEntityMapper.toCustomerEntity(customer);
		customerRepository.save(customerEntity);
	}

	
	
}
