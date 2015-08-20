package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.util.HibernateUtil;

public class AddressDAOImplTest {
	
	private Address address = new Address("Lviv");
	
	@Test
	public void testSave() {
		AddressDAOImpl addDAOImpl = new AddressDAOImpl();
		HibernateUtil.beginTransaction();
		addDAOImpl.save(address);
		HibernateUtil.commitTransaction();
		assertTrue(true);
	}

	@Test
	public void testDelete() {
		AddressDAOImpl addressDAOImpl = new AddressDAOImpl();
		HibernateUtil.beginTransaction();
		List<Address> addresses = (List<Address>) addressDAOImpl.findAll(Address.class);
		Address lastAddedAddress = (Address)addresses.get(addresses.size() - 1);
		addressDAOImpl.delete(lastAddedAddress);
		HibernateUtil.commitTransaction();
		
		HibernateUtil.beginTransaction();
		boolean result = HibernateUtil.getSession().contains(address);
		HibernateUtil.commitTransaction();
		assertFalse(result);
	}
}
