package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.Orders_ItemsController;
import com.qa.ims.persistence.dao.Orders_ItemsDAO;
import com.qa.ims.persistence.domain.Orders_Items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class Orders_ItemsControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private Orders_ItemsDAO dao;

	@InjectMocks
	private Orders_ItemsController controller;
	
	@Test
	public void testAdd() {
		final Long itemId = 1L, orderId = 1L;
		final Orders_Items created = new Orders_Items(orderId, itemId);
		
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.dao.add(created)).thenReturn(created);
		
		assertEquals(created, this.controller.add(orderId));
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).add(created);
		
	}
	
	@Test
	public void testDelete() {
		final Long itemId = 1L, orderId = 1L;
		final Orders_Items created = new Orders_Items(orderId, itemId);
		
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.dao.delete(created)).thenReturn(1);
		
		assertEquals(1, this.controller.delete(orderId));
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(created);
	}
	
	

}
