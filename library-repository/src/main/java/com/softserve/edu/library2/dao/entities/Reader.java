package com.softserve.edu.library2.dao.entities;


import org.hibernate.annotations.CascadeType;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 */
@Entity
@Table(name = "reader", catalog = "library")
public class Reader implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6208049282764164197L;
	private Integer readerId;
	private Address address;
	private String firstName;
	private String lastName;
	private String middleName;
	private String telephone;
	private Date birthDate;
	private Set<BookCopyReader> bookCopyReaders = new HashSet<BookCopyReader>(0);

	public Reader() {
	}

	public Reader(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Reader(Address address, String firstName, String lastName, String middleName, String telephone,
			Date birthDate, Set<BookCopyReader> bookCopyReaders) {
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.telephone = telephone;
		this.birthDate = birthDate;
		this.bookCopyReaders = bookCopyReaders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "reader_id", unique = true, nullable = false)
	public Integer getReaderId() {
		return this.readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	@ManyToOne(cascade = javax.persistence.CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "first_name", nullable = false, length = 30)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 30)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "middle_name", length = 20)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "telephone", length = 22)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reader")
	public Set<BookCopyReader> getBookCopyReaders() {
		return this.bookCopyReaders;
	}

	public void setBookCopyReaders(Set<BookCopyReader> bookCopyReaders) {
		this.bookCopyReaders = bookCopyReaders;
	}

}
