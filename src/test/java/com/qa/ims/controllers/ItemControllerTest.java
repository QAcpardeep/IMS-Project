package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
	@Test
	public void testReadAll() {
		
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "Koch Chemie H8.02 Heavy Cut", 12.49));
		items.add(new Item(2L, "Soft99 New Fusso Coat Dark Wax", 29.95));
		items.add(new Item(3L, "DAS 6 V2 DUAL ACTION POLISHER", 89.95));
		items.add(new Item(4L, "Bilt Hamber Auto Foam 5L", 17.95));
		items.add(new Item(5L, "Koch Chemie H11.01 Soft Cut", 12.45));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testCreate() {
		final String name = "Fusso Wax 1.9L";
		final Double value = 25.99;
		
		final Item created = new Item(name, value);

		Mockito.when(utils.getString()).thenReturn(name);
		Mockito.when(utils.getDouble()).thenReturn(value);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "Fusso Wax 1.9L", 25.99);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getValue());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
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
