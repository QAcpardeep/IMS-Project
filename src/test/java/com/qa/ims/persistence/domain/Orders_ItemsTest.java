package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class Orders_ItemsTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Orders_Items.class).verify();
	}

}
