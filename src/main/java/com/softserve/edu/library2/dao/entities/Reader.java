/**
 * Dicription Entity of Table "reader"
 */
package com.softserve.edu.library2.dao.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmytro Brylyuk
 */
@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")

    private String middleName;

    @Column(name = "telephone")
    private long telephone;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reader")
    @JoinColumn(name = "address_id")
    private Set<Address> address_id = new HashSet<Address>();

    /**
     *
     * @return id of reader
     */
    public int getId() {
        return id;
    }

    /**
     * @param id  set id of reader
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return first name of reader
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName set First Name of Reader
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return Last name of reader
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName set Last Name of reader
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return middle name of reader
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName set Middle name of reader
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     *
     * @return telephone number of reader
     */
    public long getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone set telephone number of reader
     */
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    /**
     *
     * @return Birth Date of reader
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate set Birth Date of reader
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return HashSet of address of reader
     */
    public Set<Address> getAddress_id() {
        return address_id;
    }

    /**
     * @param address_id HashSet Address of reader
     */
    public void setAddress_id(Set<Address> address_id) {
        this.address_id = address_id;
    }
}
