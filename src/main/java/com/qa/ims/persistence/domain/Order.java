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
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", cost=" + cost + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		return true;
	}

}
