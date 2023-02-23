package br.com.botton.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.botton.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.botton.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

	@Bean
	public FindCustomerByIdUseCase findCustomerByIdUseCase(
			FindCustomerByIdAdapter findCustomerByIdAdapter
			) {
		return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
	}
	
}
