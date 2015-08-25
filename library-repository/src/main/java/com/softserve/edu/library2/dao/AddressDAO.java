/**
 * 
 */
package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;

import java.util.List;

/**
 * @author Dmytro Brylyuk
 *
 */
public interface AddressDAO extends GenericDAO<Address, Integer> {

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
     * Method to find all addresses
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @param apartmentNumber int
     * @return List of address by city, region, street, number of building and number of apartment
     */
    public Address findAddress (String city, String region, String street, int buildingNumber, int apartmentNumber);

}
