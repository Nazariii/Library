package com.softserve.edu.library2.service.impl;

import com.softserve.edu.library2.dao.AddressDAO;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dmytro on 8/26/2015.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDAO addressDAO;

    /**
     * Method to find all addresses
     *
     * @param city String
     * @return - List of address by city
     */
    @Override
    @Transactional
    public List<Address> findAddress(String city) {
        return addressDAO.findAddress(city);
    }

    /**
     * Method to find all addresses
     *
     * @param city   String
     * @param region String
     * @return List of address by city and region
     */
    @Override
    @Transactional
    public List<Address> findAddress(String city, String region) {
        return addressDAO.findAddress(city, region);
    }

    /**
     * Method to find all addresses
     *
     * @param city   String
     * @param region String
     * @param street String
     * @return List of address by city, region and street
     */
    @Override
    @Transactional
    public List<Address> findAddress(String city, String region, String street) {
        return addressDAO.findAddress(city, region, street);
    }

    /**
     * Method to find all addresses
     *
     * @param city           String
     * @param region         String
     * @param street         String
     * @param buildingNumber int
     * @return List of address by city, region, street and number of building
     */
    @Override
    @Transactional
    public List<Address> findAddress(String city, String region, String street, int buildingNumber) {
        return addressDAO.findAddress(city, region, street, buildingNumber);
    }

    /**
     * Method to find address
     *
     * @param city            String
     * @param region          String
     * @param street          String
     * @param buildingNumber  int
     * @param apartmentNumber int
     * @return List of address by city, region, street, number of building and number of apartment
     */
    @Override
    @Transactional
    public Address findAddress(String city, String region, String street, int buildingNumber,
                               int apartmentNumber) {
        return addressDAO.findAddress(city, region, street, buildingNumber, apartmentNumber);
    }
}
