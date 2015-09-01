package com.softserve.edu.library2.service.impl;

import com.softserve.edu.library2.dao.ReaderDAO;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author Dmytro Brylyuk.
 */
@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    ReaderDAO readerDAO;

    /**
     * Method finds reader by first name and last name
     * @param firstName - name of reader
     * @param lastName - lastname of reader
     * @return List of readers
     */
    @Override
    @Transactional
    public List<Reader> findByName(String firstName, String lastName) {
        return readerDAO.findByName(firstName, lastName);
    }

    /**
     * Method to finnd readers by address where they are lives
     * @param address - object of entity Address
     * @return List of readers
     */
    @Override
    @Transactional
    public List<Reader> findByAddress(Address address) {
        return readerDAO.findByAddress(address);
    }

    /**
     * Method to find readers by telephone number
     * @param telephone - telephone number of reader
     * @return - object reader
     */
    @Override
    @Transactional
    public Reader findByTelephone(String telephone) {
        return readerDAO.findByTelephone(telephone);
    }

    /**
     * Method to find readers by birth date
     * @param birthDate - birth date of readers/reader
     * @return - List of readers
     */
    @Override
    @Transactional
    public List<Reader> findByBirthDate(Date birthDate) {
        return readerDAO.findByBirthDate(birthDate);
    }

    /**
     * Method to find readers by book wich they are takenn
     * @param name - title of book
     * @return - List of readers
     */
    @Override
    @Transactional
    public List<Reader> findByBook(String name) {
        return readerDAO.findByBook(name);
    }

    /**
     * Method to find readers by city
     * @param city String
     * @return - List of address by city
     */
    @Override
    @Transactional
    public List<Reader> findByAddress(String city) {
        return readerDAO.findByAddress(city);
    }

    /**
     * Method to find readers by city and region
     * @param city String
     * @param region String
     * @return List of address by city and region
     */
    @Override
    @Transactional
    public List<Reader> findByAddress(String city, String region) {
        return readerDAO.findByAddress(city, region);
    }

    /**
     * Method to find readers by city,region and street
     * @param city String
     * @param region String
     * @param street String
     * @return List of address by city, region and street
     */
    @Override
    @Transactional
    public List<Reader> findByAddress(String city, String region, String street) {
        return readerDAO.findByAddress(city, region, street);
    }

    /**
     * Method to find readers by city,region, street and number of building
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @return List of address by city, region, street and number of building
     */
    @Override
    @Transactional
    public List<Reader> findByAddress(String city, String region, String street, int buildingNumber) {
        return readerDAO.findByAddress(city, region, street, buildingNumber);
    }

    /**
     * Method to find readers by city,region, street, number of building and number of apartment
     * @param city String
     * @param region String
     * @param street String
     * @param buildingNumber int
     * @param apartmentNumber int
     * @return List of address by city, region, street, number of building and number of apartment
     */
    @Override
    @Transactional
    public List<Reader> findByAddress(String city, String region, String street, int buildingNumber,
                                      int apartmentNumber) {
        return readerDAO.findByAddress(city, region, street, buildingNumber, apartmentNumber);
    }

    /**
     * Method to find reader by id
     *
     * @param id Integer id number
     * @return reader
     */
    @Override
    @Transactional
    public Reader findById(Integer id) {
        return readerDAO.findByID(Reader.class, id);
    }

    /**
     * Method to save reader in database
     *
     * @param reader object reader
     */
    @Override
    @Transactional
    public void save(Reader reader) {
        readerDAO.save(reader);
    }

    /**
     * Method to change data about reader in database
     *
     * @param reader object reader
     */
    @Override
    @Transactional
    public void update(Reader reader) {
        Reader entity = readerDAO.findByID(Reader.class, reader.getReaderId());
        if (entity != null) {
            entity.setReaderId(reader.getReaderId());
            entity.setFirstName(reader.getFirstName());
            entity.setLastName(reader.getLastName());
            entity.setMiddleName(reader.getMiddleName());
            entity.setTelephone(reader.getTelephone());
            entity.setBirthDate(reader.getBirthDate());
            entity.setAddress(reader.getAddress());
            entity.setBookCopyReaders(reader.getBookCopyReaders());
        }
    }

    /**
     * Method to select list of all readers in database
     *
     * @return
     */
    @Override
    @Transactional
    public List<Reader> findAll() {
        return readerDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id){
        readerDAO.deleteById(id);
    }
}
