package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.util.HibernateUtil;

/*
 * @author Taras and Dmytro
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressDAOImplTest {
	
	private static Address address = new Address("Kyiv");
	private static AddressDAOImpl addressDAOImpl = new AddressDAOImpl();

	@Ignore
	@Test
	public void stage1_testSave() {		
		HibernateUtil.beginTransaction();
		addressDAOImpl.save(address);
		HibernateUtil.commitTransaction();
		
		HibernateUtil.beginTransaction();
		List<Address> addresses = addressDAOImpl.findAll(Address.class);
		Address lastAddedAddress = (Address)addresses.get(addresses.size() - 1);
		HibernateUtil.commitTransaction();
		
		assertTrue(address.getAddressId().equals(lastAddedAddress.getAddressId())
				&& address.getCity().equals(lastAddedAddress.getCity()));
	}
	
	@Test
	public void stage2_testMerge() {
		address.setApartmentNumber(42);
		
		HibernateUtil.beginTransaction();
		List<Address> addresses = addressDAOImpl.findAll(Address.class);
		Address lastAddedAddress = (Address)addresses.get(addresses.size() - 1);
		lastAddedAddress.setApartmentNumber(42);	
		addressDAOImpl.merge(lastAddedAddress);
		HibernateUtil.commitTransaction();
		
		HibernateUtil.beginTransaction();
		Query query = HibernateUtil.getSession()
				.createQuery("FROM Address WHERE city = 'Kyiv' AND apartment_number = 42");	
		Address mergedAddress = addressDAOImpl.findOne(query);
		HibernateUtil.commitTransaction();
		
		assertTrue(lastAddedAddress.getAddressId().equals(mergedAddress.getAddressId())
				&&	lastAddedAddress.getApartmentNumber().equals(mergedAddress.getApartmentNumber())
						&& lastAddedAddress.getCity().equals(mergedAddress.getCity()));
	}
	
	@Test
	public void stage3_testFindOne() {
		HibernateUtil.beginTransaction();
		Query query = HibernateUtil.getSession()
				.createQuery("FROM Address WHERE city = 'Kyiv' AND apartment_number = 42");	
		Address foundAddress = addressDAOImpl.findOne(query);
		HibernateUtil.commitTransaction();
		
		assertTrue(address.getApartmentNumber().equals(foundAddress.getApartmentNumber())
						&& address.getCity().equals(foundAddress.getCity()));
	}
	
	@Test
	public void stage4_testDelete() {
		HibernateUtil.beginTransaction();
		
		List<Address> addresses = addressDAOImpl.findAll(Address.class);
		Address lastAddedAddress = (Address)addresses.get(addresses.size() - 1);
		addressDAOImpl.delete(lastAddedAddress);
		HibernateUtil.commitTransaction();
		
		HibernateUtil.beginTransaction();
		boolean result = HibernateUtil.getSession().contains(lastAddedAddress);
		HibernateUtil.commitTransaction();
		
		assertFalse(result);
	}

	@Test
	public void testFindAddress() throws Exception {

	}

	@Test
	public void testFindAddress1() throws Exception {

	}

	@Test
	public void testFindAddress2() throws Exception {

	}

	@Test
	public void testFindAddress3() throws Exception {

	}

	@Test
	public void testFindAddress4() throws Exception {

	}
}
