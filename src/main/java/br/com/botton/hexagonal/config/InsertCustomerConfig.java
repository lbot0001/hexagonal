package br.com.botton.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.botton.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.botton.hexagonal.adapters.out.InsertCustomerAdapter;
import br.com.botton.hexagonal.application.core.usecase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {

	@Bean
	public InsertCustomerUseCase insertCustomerUserCase(
		FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
		InsertCustomerAdapter insertCustomerAdapter) {
		return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
	};
	
}
