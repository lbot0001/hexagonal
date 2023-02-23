package br.com.botton.hexagonal.adapters.in.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.botton.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.botton.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.botton.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.botton.hexagonal.application.core.domain.Customer;
import br.com.botton.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.botton.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.botton.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.botton.hexagonal.application.ports.in.UpdateCustomerInputPort;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private InsertCustomerInputPort insertCustomerInputPort;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private FindCustomerByIdInputPort findCustomerByIdInputPort;
	
	@Autowired
	private UpdateCustomerInputPort updateCustomerInputPort;
	
	@Autowired 
	private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody CustomerRequest customerRequest){
		insertCustomerInputPort.insert(customerMapper.toCustomer(customerRequest), customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
		//como acessar o caso de uso para buscar o customer por id?
		//precisamos de uma porta de entrada
		var customer = findCustomerByIdInputPort.find(id);
		var customerResponse = customerMapper.toCustomerResponse(customer);
		return ResponseEntity.ok().body(customerResponse);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
		Customer customer = customerMapper.toCustomer(customerRequest);
		customer.setId(id);
		updateCustomerInputPort.update(customer, id);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final String id){
		deleteCustomerByIdInputPort.delete(id);
		return ResponseEntity.noContent().build();
	}
}
