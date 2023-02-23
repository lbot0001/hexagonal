package br.com.botton.hexagonal.application.core.usecase;

import br.com.botton.hexagonal.application.core.domain.Customer;
import br.com.botton.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.botton.hexagonal.application.ports.in.UpdateCustomerInputPort;
import br.com.botton.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.botton.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort{
	
	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	
	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	
	private final UpdateCustomerOutputPort updateCustomerOutputPort;
	
	public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
			FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
			UpdateCustomerOutputPort updateCustomerOutputPort) {
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.updateCustomerOutputPort = updateCustomerOutputPort;
	}

	@Override
	public void update(Customer customer, String zipCode) {
		//para atualizar um customer, precisamos primeiro verificar se ele existe
		//por isso o uso do port do customer use case
		findCustomerByIdInputPort.find(customer.getId());
		//depois precisamos buscar o endereco
		var address = findAddressByZipCodeOutputPort.find(zipCode);
		//alterar o endereco do usuario
		customer.setAddress(address);
		//salvar
		updateCustomerOutputPort.update(customer);
	}
	
	
	
}
