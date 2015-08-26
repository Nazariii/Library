package com.softserve.edu.library2.service;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;

import java.util.Date;
import java.util.List;

/**
 * Created by Dmytro on 8/25/2015.
 */
public interface ReaderService {

    /**
     * Method finds reader by first name and last name
     * @param firstName - name of reader
     * @param lastName - lastname of reader
     * @return List of readers
     */
    public List<Reader> findByName(String firstName, String lastName);

    /**
     * Method to finnd readers by address where they are lives
     * @param address - object of entity Address
     * @return List of readers
     */
    public List<Reader> findByAddress(Address address);

    /**
     * Method to find readers by telephone number
     * @param telephone - telephone number of reader
     * @return - object reader
     */
    public Reader findByTelephone(String telephone);

    /**
     * Method to find readers by birth date
     * @param birthDate - birth date of readers/reader
     * @return - List of readers
     */

    public List<Reader> findByBirthDate(Date birthDate);

    /**
     * Method to find readers by book wich they are takenn
     * @param name - title of book
     * @return - List of readers
     */
    public List<Reader> findByBook(String name);

    /**
     * Method to find readers by city
     * @param city String
     * @return - List of address by city
     */
    public List<Reader> findByAddress (String city);

    /**
     * Method to find readers by city and region
     * @param city String
     * @param region String
     * @return List of address by city and region
     */
    public List<Reader> findByAddress (String city, String region);

    /**
     * Method to find readers by city,region and street
     * @param city String
     * @param region String
     * @param street String
     * @return List of address by city, region and street
     */
    public List<Reader> findByAddress (String city, String region, String street);

    /**
     * Method to find readers by city,region, street and number of building
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @return List of address by city, region, street and number of building
     */
    public List<Reader> findByAddress (String city, String region, String street, int buildingNumber);

    /**
     * Method to find readers by city,region, street, number of building and number of apartment
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @param apartmentNumber int
     * @return List of address by city, region, street, number of building and number of apartment
     */
    public List<Reader> findByAddress (String city, String region, String street, int buildingNumber, int apartmentNumber);

}
