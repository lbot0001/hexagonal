package br.com.botton.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.botton.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.botton.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.botton.hexagonal.application.core.domain.Customer;
import br.com.botton.hexagonal.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerEntityMapper customerEntityMapper;
	
	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		
		customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
	}

}
