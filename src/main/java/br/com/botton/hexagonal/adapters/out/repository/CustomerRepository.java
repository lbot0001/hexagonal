package br.com.botton.hexagonal.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.botton.hexagonal.adapters.out.repository.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String>{

}
