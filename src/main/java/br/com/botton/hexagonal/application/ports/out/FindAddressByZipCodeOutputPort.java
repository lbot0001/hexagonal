package br.com.botton.hexagonal.application.ports.out;

import br.com.botton.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
	
	Address find(String zipCode);

}
