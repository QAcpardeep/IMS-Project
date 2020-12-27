package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.Orders_ItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private final Orders_ItemsController orders_items;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
		final Orders_ItemsDAO orders_itemsDAO = new Orders_ItemsDAO();
		this.orders_items = new Orders_ItemsController(orders_itemsDAO, utils);
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter customer ID");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		Long orderId = order.getId();
		action(orderId);
		return order;
	}
	
	/**
	 * Updates an existing order by adding or removing an item from the order. 
	 */
	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Creates, updates and removes an item from the order. 
	 */
	public void action(Long orderId) {
		boolean exit = false;
		do {
			LOGGER.info("What do you want to do?");
			LOGGER.info("ADD: add an item to the order");
			LOGGER.info("EXIT: return to main menu");

			String selector = utils.getString();
			
			switch (selector.toUpperCase()) {
				case "ADD":
					orders_items.add(orderId);
					LOGGER.info("item added");
					break;
				case "EXIT":
					exit = true;
			}
		} while (!exit);
	}

}
