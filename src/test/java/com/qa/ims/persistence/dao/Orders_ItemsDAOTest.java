package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders_Items;
import com.qa.ims.utils.DBUtils;

public class Orders_ItemsDAOTest {
	
	private final Orders_ItemsDAO DAO = new Orders_ItemsDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Orders_Items(2L, 2L, 1L), DAO.readLatest());
	}

	@Test
	public void testAdd() {
		final Orders_Items created = new Orders_Items(3L, 1L, 4L);
		Orders_Items results = DAO.add(created.getOrderId(), created.getItemId());
		assertEquals(created, results);
		assertEquals(created.getId(), results.getId());
		System.out.println(results.toString());
	}
	
	@Test
	public void testDelete() {
		final Orders_Items created = new Orders_Items(2L, 1L);
		assertEquals(1, DAO.delete(created.getOrderId(), created.getItemId()));
	}
	
	
}
