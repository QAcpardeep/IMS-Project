package com.qa.ims.persistence.domain;

public class Orders_Items {

	//Initialising private fields
	private Long id;
	private Long orderId;
	private Long itemId;
	
	//Constructor taking in parameters and calling methods to assign given parameters.
	public Orders_Items(Long orderId, Long itemId) {
		this.setOrderId(orderId);
		this.setItemId(itemId);
	}
	
	//Second constructors which assigns the parameters to the fields by calling the methods.
	public Orders_Items(Long id, Long orderId, Long itemId) {
		this.setId(id);
		this.setOrderId(orderId);
		this.setItemId(itemId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

}
