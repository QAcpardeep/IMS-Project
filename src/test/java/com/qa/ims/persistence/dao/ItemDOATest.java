package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDOATest {
	
	private final ItemDAO DAO = new ItemDAO();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(6L, "Meguairs A2 shampoo 2L", 29.99);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Koch Chemie H8.02 Heavy Cut", 12.49));
		expected.add(new Item(2L, "Soft99 New Fusso Coat Dark Wax", 29.95));
		expected.add(new Item(3L, "DAS 6 V2 DUAL ACTION POLISHER", 89.95));
		expected.add(new Item(4L, "Bilt Hamber Auto Foam 5L", 17.95));
		expected.add(new Item(5L, "Koch Chemie H11.01 Soft Cut", 12.45));
		System.out.println(DAO.readAll());
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item(5L, "Koch Chemie H11.01 Soft Cut", 12.45), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "Koch Chemie H8.02 Heavy Cut", 12.49), DAO.readItem(ID));
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "Meguairs A2 shampoo 2L", 29.99);
		assertEquals(updated, DAO.update(updated));

	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(5));
	}

	
}
