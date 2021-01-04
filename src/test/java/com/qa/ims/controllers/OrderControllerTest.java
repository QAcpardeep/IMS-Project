package com.qa.ims.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.Orders_ItemsController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.Orders_ItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_Items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;
	
	@Mock
	private Orders_ItemsDAO oiDAO;

	@InjectMocks
	private OrderController controller;
	
	@InjectMocks
	private Orders_ItemsController oiController;
	
	@Test 
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, 0.0));
		expected.add(new Order(2L, 3L, 0.0));
		
		Mockito.when(dao.readAll()).thenReturn(expected);
		assertEquals(expected, controller.readAll());
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test 
	public void testCreate() {
		final Long customerId = 1L;
		final Order created = new Order(3L, 1L, 0.0);
		final Orders_Items item = new Orders_Items (3L, 6L, 1L);
		
		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(dao.create(created)).thenReturn(created);
		Mockito.when(utils.getString()).thenReturn("add", "exit");
		Mockito.when(oiDAO.add(item)).thenReturn(null);
		Mockito.when(dao.update(created)).thenReturn(created);

		assertEquals(created, controller.create());
		
	}
	
	@Test 
	public void testUpdate() {
		final Long orderId = 1L;
		final Order order = new Order(3L, 1L, 0.0);
		final Orders_Items item = new Orders_Items (3L, 1L, 1L);
		
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(utils.getString()).thenReturn("add", "remove", "exit");
		Mockito.when(oiController.add(orderId)).thenReturn(null);
		Mockito.when(oiController.delete(orderId)).thenReturn(0);
		Mockito.when(dao.readOrder(3L)).thenReturn(order);
		Mockito.when(dao.update(order)).thenReturn(order);
		assertEquals(order, controller.update());
		
		
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	

}