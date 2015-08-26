package com.softserve.edu.library2.service.impl;

import com.softserve.edu.library2.config.AppConfig;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dmytro on 8/26/2015.
 */
public class AddressServiceImplTest {

    AbstractApplicationContext context;
    AddressService addressService;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        addressService = (AddressService) context.getBean("addressServiceImpl");

    }

    @Test
    public void testFindAddress() throws Exception {
        final String city = "Lviv";

        List<Address> listAddresses = addressService.findAddress(city);

        for (Address address : listAddresses) {
            assertEquals(city, address.getCity());
        }
    }

    @Test
    public void testFindAddress1() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";

        List<Address> listAddresses = addressService.findAddress(city, region);

        for (Address address : listAddresses) {
            assertEquals(city, address.getCity());
            assertEquals(region, address.getRegion());
        }
    }

    @Test
    public void testFindAddress2() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        final String street = "Bandery";

        List<Address> listAddresses = addressService.findAddress(city, region, street);

        for (Address address : listAddresses) {
            assertEquals(city, address.getCity());
            assertEquals(region, address.getRegion());
            assertEquals(street, address.getStreet());
        }
    }

    @Test
    public void testFindAddress3() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        final String street = "Bandery";
        final Integer buildingNumber = 5;

        List<Address> listAddresses = addressService.findAddress(city, region, street, buildingNumber);

        for (Address address : listAddresses) {
            assertEquals(city, address.getCity());
            assertEquals(region, address.getRegion());
            assertEquals(street, address.getStreet());
            assertEquals(buildingNumber, address.getBuildingNumber());
        }
    }

    @Test
    public void testFindAddress4() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        final String street = "Bandery";
        final Integer buildingNumber = 5;
        final Integer apartmentNumber = 1;

        Address address = addressService.findAddress(city, region, street, buildingNumber, apartmentNumber);

        assertEquals(city, address.getCity());
        assertEquals(region, address.getRegion());
        assertEquals(street, address.getStreet());
        assertEquals(buildingNumber, address.getBuildingNumber());
        assertEquals(apartmentNumber, address.getApartmentNumber());
    }
}