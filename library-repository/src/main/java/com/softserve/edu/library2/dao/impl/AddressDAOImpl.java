package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.AddressDAO;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

/**
 * @author Dmytro Brylyuk
 */
@Repository
public class AddressDAOImpl extends AbstractDAO<Address, Integer> implements AddressDAO {

    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * Method to find all addresses
     *
     * @param city String
     * @return - List of address by city
     */
    @Override
    public List<Address> findAddress(String city) {
        String sql = "FROM Address WHERE city = :city";
        Query query = super.getSession().createQuery(sql).setString("city", city);
        List<Address> listAddresses = Collections.emptyList();
        try {
            listAddresses = findMany(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return listAddresses;
    }

    /**
     * Method to find all addresses
     *
     * @param city   String
     * @param region String
     * @return List of address by city and region
     */
    @Override
    public List<Address> findAddress(String city, String region) {
        String sql = "FROM Address WHERE city = :city AND region = :region";
        Query query = super.getSession().createQuery(sql).setString("city", city)
                .setString("region", region);
        List<Address> listAddresses = Collections.emptyList();
        try {
            listAddresses = findMany(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return listAddresses;
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
    public List<Address> findAddress(String city, String region, String street) {
        String sql = "FROM Address WHERE city = :city AND region = :region " +
                "AND street = :street";
        Query query = super.getSession().createQuery(sql).setString("city", city)
                .setString("region", region).setString("street", street);
        List<Address> listAddresses = Collections.emptyList();
        try {
            listAddresses = findMany(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return listAddresses;
    }

    /**
     * Method to find all addresses
     *
     * @param city     String
     * @param region   String
     * @param street   String
     * @param buildingNumber int
     * @return List of address by city, region, street and number of building
     */
    @Override
    public List<Address> findAddress(String city, String region, String street,
                                     int buildingNumber) {
        String sql = "FROM Address WHERE city = :city AND region = :region " +
                "AND street = :street AND buildingNumber = :buildingNumber";
        Query query = super.getSession().createQuery(sql).setString("city", city)
                .setString("region", region).setString("street", street)
                .setInteger("buildingNumber", buildingNumber);
        List<Address> listAddresses = Collections.emptyList();
        try {
            listAddresses = findMany(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return listAddresses;
    }

    /**
     * Method to find address
     *
     * @param city      String
     * @param region    String
     * @param street    String
     * @param buildingNumber  int
     * @param apartmentNumber int
     * @return List of address by city, region, street, number of building and number of apartment
     */
    @Override
    public Address findAddress(String city, String region, String street,
                                     int buildingNumber, int apartmentNumber) {
        String sql = "FROM Address WHERE city = :city AND region = :region " +
                "AND street = :street AND buildingNumber = :buildingNumber " +
                "AND apartmentNumber = :apartmentNumber";
        Query query = super.getSession().createQuery(sql).setString("city", city)
                .setString("region", region).setString("street", street)
                .setInteger("buildingNumber", buildingNumber).setInteger("apartmentNumber", apartmentNumber);
        Address address = null;
        try {
            address = findOne(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return address;
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw logger.throwing(new NullPointerException("Reader id to delete is null"));
        }
        Address address = findByID(Address.class, id);
        if (address == null) {
            throw new EntityNotFoundException("Reader not found for deleting");
        }
        delete(address);

    }
}
