package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTestL {
private final ItemDAO DAO = new ItemDAO();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect(" ", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(6L, "Meguairs A2 shampoo 2L", 29.99);
		assertNull(DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertNull( DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertNull(DAO.readItem(ID));
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "Meguairs A2 shampoo 2L", 29.99);
		assertNull(DAO.update(updated));

	}
	
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(5));
	}
}
