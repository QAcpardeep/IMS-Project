package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.Orders_ItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
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
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input: customer ID. 
	 * Once the order created it will ask you to add items to the order, by default you have to add an item. 
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter customer ID");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		Long orderId = order.getId();
		orders_items.add(orderId);
		
		boolean exit = false;
		do {
			
			LOGGER.info("Do you want to add another item?");
			LOGGER.info("ADD: add an item to the order");
			LOGGER.info("EXIT: return to main menu");

			String selector = utils.getString();
			
			switch (selector.toUpperCase()) {
				case "ADD":
					orders_items.add(orderId);
					break;
				case "EXIT":
					exit = true;
			}
		} while (!exit);
		
		//Updates the cost of the order
		return orderDAO.update(order);
	}
	
	/**
	 * Updates an existing order by adding or removing an item from the order. 
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter order ID you would like to update?");
		Long orderId = utils.getLong();
		boolean exit = false;
		do {
			LOGGER.info("What do you want to do?");
			LOGGER.info("ADD: add an item to the order");
			LOGGER.info("REMOVE: remove an item from the order");
			LOGGER.info("EXIT: return to main menu");

			String selector = utils.getString();
			
			switch (selector.toUpperCase()) {
				case "ADD":
					orders_items.add(orderId);
					break;
				case "REMOVE":
					orders_items.delete(orderId);
					break;
				case "EXIT":
					exit = true;
			}
		} while (!exit);
		
		//Updates the cost of the order
		Order o = orderDAO.readOrder(orderId);
		return orderDAO.update(o);
	}
	
	/**
	 * Deletes an existing order by taking user input: order id. 
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
