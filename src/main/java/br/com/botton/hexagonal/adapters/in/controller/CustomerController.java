package br.com.botton.hexagonal.adapters.in.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.botton.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.botton.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.botton.hexagonal.application.ports.in.InsertCustomerInputPort;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private InsertCustomerInputPort insertCustomerInputPort;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody CustomerRequest customerRequest){
		insertCustomerInputPort.insert(customerMapper.toCustomer(customerRequest), customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}

}
