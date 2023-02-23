package br.com.botton.hexagonal.config;

import br.com.botton.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.botton.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.botton.hexagonal.adapters.out.UpdateCustomerAdapter;
import br.com.botton.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import br.com.botton.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
