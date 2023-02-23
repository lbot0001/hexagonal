package br.com.botton.hexagonal.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.botton.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.botton.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.botton.hexagonal.application.core.domain.Customer;
import br.com.botton.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort{

	//precisamos conectar no repositorio para buscar um cliente
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerEntityMapper customerEntityMapper;
	
	@Override
	public Optional<Customer> find(String id) {
		var customerEntity = customerRepository.findById(id);
		return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
	}
	
}
