package com.softserve.edu.library2.dao.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name = "address", catalog = "library")
public class Address implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6824544329560870365L;
	private Integer addressId;
	private String city;
	private String region;
	private String street;
	private Integer buildingNumber;
	private Integer apartmentNumber;
	private Set<Reader> readers = new HashSet<Reader>(0);

	public Address() {
	}

	public Address(String city) {
		this.city = city;
	}

	public Address(String city, String region, String street, Integer buildingNumber, Integer apartmentNumber,
			Set<Reader> readers) {
		this.city = city;
		this.region = region;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.apartmentNumber = apartmentNumber;
		this.readers = readers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "city", nullable = false, length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "region", length = 20)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "street", length = 30)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "building_number")
	public Integer getBuildingNumber() {
		return this.buildingNumber;
	}

	public void setBuildingNumber(Integer buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	@Column(name = "apartment_number")
	public Integer getApartmentNumber() {
		return this.apartmentNumber;
	}

	public void setApartmentNumber(Integer apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Reader> getReaders() {
		return this.readers;
	}

	public void setReaders(Set<Reader> readers) {
		this.readers = readers;
	}

}
