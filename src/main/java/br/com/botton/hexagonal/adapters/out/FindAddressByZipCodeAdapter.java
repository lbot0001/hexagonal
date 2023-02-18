package br.com.botton.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.botton.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import br.com.botton.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.botton.hexagonal.application.core.domain.Address;
import br.com.botton.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

//ADAPTER: Implementacao da porta de saida ou entrada
//Component, spring vai gerenciar, fora do core
//Inclusao de um mapper para isolamento dos objetos
@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort{

	@Autowired
	private FindAddressByZipCodeClient findAddressByZipCodeClient;
	
	@Autowired 
	private AddressResponseMapper addressResponseMapper;
	
	@Override
	public Address find(String zipCode) {
		var addressResponse = findAddressByZipCodeClient.find(zipCode);
		return addressResponseMapper.toAddress(addressResponse);
	}
	
}
