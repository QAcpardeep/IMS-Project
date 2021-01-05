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
	private Orders_ItemsDAO orders_itemsDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Orders_ItemsDAO orders_itemsDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
		this.orders_itemsDAO = orders_itemsDAO;
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
		LOGGER.info("what is the item ID?");
		Long itemID = utils.getLong();
		orders_itemsDAO.add(orderId, itemID);
		
		boolean exit = false;
		do {
			
			LOGGER.info("Do you want to add another item?");
			LOGGER.info("ADD: add an item to the order");
			LOGGER.info("EXIT: return to main menu");

			String selector = utils.getString();
			
			switch (selector.toUpperCase()) {
				case "ADD":
					LOGGER.info("what is the item ID?");
					Long itemId = utils.getLong();
					orders_itemsDAO.add(orderId, itemId);
					break;
				case "EXIT":
					exit = true;
			}
		} while (!exit);
		
		//Updates the cost of the order
		Order o = orderDAO.update(order);
		LOGGER.info(o);
				
		return o;
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
					LOGGER.info("what is the item ID?");
					Long addItemId = utils.getLong();
					orders_itemsDAO.add(orderId, addItemId);
					LOGGER.info("added items to the order");
					break;
				case "REMOVE":
					LOGGER.info("what is the item ID?");
					Long deleteItemId = utils.getLong();
					orders_itemsDAO.delete(orderId, deleteItemId);
					LOGGER.info("Item deleted from the order");
					break;
				case "EXIT":
					exit = true;
			}
		} while (!exit);
		
		//Updates the cost of the order
		Order x = orderDAO.readOrder(orderId);
		return orderDAO.update(x);
		
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
