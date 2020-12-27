package com.qa.ims.persistence.domain;

public class Order {
	// Initialising private fields
	private Long id;
	private Long customerId;
	private Double cost;

	// Constructor taking in parameters and calling methods to assign given
	// parameters.
	public Order(Long customerId) {
		this.setCustomerId(customerId);
	}
	
	//Second constructors which assigns the parameters to the fields by calling the methods.
	public Order(Long id, Long customerId, Double cost) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setCost(cost);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
