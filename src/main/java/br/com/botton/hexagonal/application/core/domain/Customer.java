package br.com.botton.hexagonal.application.core.domain;

//Essa classe nao pode ser usada para representar as entidades do repositorio do mongo
//porque precisamos de anotacoes como @Id, etc. e o core precisa ser framework free
public class Customer {

	private String id;
	private String name;
	private Address address;
	private String cpf;
	private Boolean isValid;
	
	public Customer() {
		this.isValid = false;
	}
	
	public Customer(String id, String name, Address address, String cpf, Boolean isValid) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cpf = cpf;
		this.isValid = isValid;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	
	
}
