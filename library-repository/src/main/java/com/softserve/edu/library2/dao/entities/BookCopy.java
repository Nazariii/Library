package com.softserve.edu.library2.dao.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 */
@Entity
@Table(name = "book_copy", catalog = "library")
public class BookCopy implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2932433953658976488L;
	private Integer bookCopyId;
	private Book book;
	private Character isPresent;
	private Date returningDate;
	private Date borrowingDate;
	private Set<BookCopyReader> bookCopyReaders = new HashSet<BookCopyReader>();

	public BookCopy() {
	}

	public BookCopy(Book book) {
		this.book = book;
	}

	public BookCopy(Book book, Character isPresent, Date returningDate, Date borrowingDate,
			Set<BookCopyReader> bookCopyReaders) {
		this.book = book;
		this.isPresent = isPresent;
		this.returningDate = returningDate;
		this.borrowingDate = borrowingDate;
		this.bookCopyReaders = bookCopyReaders;
	}

	public BookCopy(Book book, Character isPresent, Date returningDate, Date borrowingDate
					) {
		this.book = book;
		this.isPresent = isPresent;
		this.returningDate = returningDate;
		this.borrowingDate = borrowingDate;
		this.bookCopyReaders = null;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "book_copy_id", unique = true, nullable = false)
	public Integer getBookCopyId() {
		return this.bookCopyId;
	}

	public void setBookCopyId(Integer bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn", nullable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Column(name = "is_present", length = 1)
	public Character getIsPresent() {
		return this.isPresent;
	}

	public void setIsPresent(Character isPresent) {
		this.isPresent = isPresent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "returning_date", length = 19)
	public Date getReturningDate() {
		return this.returningDate;
	}

	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "borrowing_date", length = 19)
	public Date getBorrowingDate() {
		return this.borrowingDate;
	}

	public void setBorrowingDate(Date borrowingDate) {
		this.borrowingDate = borrowingDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookCopy", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	public Set<BookCopyReader> getBookCopyReaders() {
		return this.bookCopyReaders;
	}

	public void setBookCopyReaders(Set<BookCopyReader> bookCopyReaders) {
		this.bookCopyReaders = bookCopyReaders;
	}

}
