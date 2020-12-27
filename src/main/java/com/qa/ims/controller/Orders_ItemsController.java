package com.qa.ims.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.Orders_ItemsDAO;
import com.qa.ims.persistence.domain.Orders_Items;
import com.qa.ims.utils.Utils;

/**
 * Takes in details of items and order
 *
 */
public class Orders_ItemsController {
	public static final Logger LOGGER = LogManager.getLogger();
	private Orders_ItemsDAO orders_itemsDAO;
	private Utils utils;
	
	public Orders_ItemsController(Orders_ItemsDAO orders_itemsDAO, Utils utils) {
		super();
		this.orders_itemsDAO = orders_itemsDAO;
		this.utils = utils;
	}
	
	/**
	 * Adds an item to an order. 
	 */
	public Orders_Items add(Long orderId) {
		LOGGER.info("what is the item id");
		Long itemId = utils.getLong();
		LOGGER.info("adding items in the order");
		Orders_Items orders_items = orders_itemsDAO.create(new Orders_Items(orderId, itemId));
		LOGGER.info("added items to the order");
		return orders_items;
	}

	

}
