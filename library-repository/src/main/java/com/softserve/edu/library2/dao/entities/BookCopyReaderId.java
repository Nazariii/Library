package com.softserve.edu.library2.dao.entities;

// Generated Aug 20, 2015 4:19:05 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BookCopyReaderId generated by hbm2java
 */
@Embeddable
public class BookCopyReaderId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3269975126922764640L;
	private int readerId;
	private long isbn;

	public BookCopyReaderId() {
	}

	public BookCopyReaderId(int readerId, long isbn) {
		this.readerId = readerId;
		this.isbn = isbn;
	}

	@Column(name = "reader_id", nullable = false)
	public int getReaderId() {
		return this.readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	@Column(name = "isbn", nullable = false)
	public long getIsbn() {
		return this.isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BookCopyReaderId))
			return false;
		BookCopyReaderId castOther = (BookCopyReaderId) other;

		return (this.getReaderId() == castOther.getReaderId()) && (this.getIsbn() == castOther.getIsbn());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getReaderId();
		result = 37 * result + (int) this.getIsbn();
		return result;
	}

}
