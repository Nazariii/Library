package com.softserve.edu.library2.service;

import com.softserve.edu.library2.dao.entities.Address;

import java.util.List;

/**
 * Created by Dmytro on 8/26/2015.
 */
public interface AddressService {

    /**
     * Method to find all addresses
     * @param city String
     * @return - List of address by city
     */
    public List<Address> findAddress (String city);

    /**
     * Method to find all addresses
     * @param city String
     * @param region String
     * @return List of address by city and region
     */
    public List<Address> findAddress (String city, String region);

    /**
     * Method to find all addresses
     * @param city String
     * @param region String
     * @param street String
     * @return List of address by city, region and street
     */
    public List<Address> findAddress (String city, String region, String street);

    /**
     * Method to find all addresses
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @return List of address by city, region, street and number of building
     */
    public List<Address> findAddress (String city, String region, String street, int buildingNumber);

    /**
     * Method to find address
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @param apartmentNumber int
     * @return List of address by city, region, street, number of building and number of apartment
     */
    public Address findAddress (String city, String region, String street, int buildingNumber, int apartmentNumber);

    /**
     * Method to find address by id
     * @param id Integer id number
     * @return address
     */
    public Address findById(Integer id);

    /**
     * Method to save address in database
     * @param address object address
     */
    public void save(Address address);

    /**
     * Method to change data about addresses in database
     * @param address object address
     */
    public void update (Address address);

    /**
     * Method to select list of all addresses in database
     * @return list of address wich are in the database
     */
    public List<Address> findAll();

    /**
     * Find id of inserted address
     * @param address
     * @return
     */
    public Integer findIdByAddress(Address address);

    public void deleteById(Integer id);
}
