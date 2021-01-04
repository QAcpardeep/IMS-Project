package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTestL {

	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("yay", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(3L, 1L, 0.0);
		Order x = DAO.create(created);
		assertNull(x);
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertNull(DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertNull(DAO.readOrder(ID));
	}

	@Test
	public void testUpdate() {
		final Order x = new Order(1L, 1L, 0.0);
		Order result = DAO.update(x);
		assertNull(result);
	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(2));
	}


}
