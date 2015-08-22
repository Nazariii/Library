package com.softserve.edu.library2.dao.entities;

// Generated Aug 20, 2015 4:19:05 PM by Hibernate Tools 4.3.1

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "book", catalog = "library")
public class Book implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2207593954307681988L;
	private long isbn;
	private Author author;
	private String name;
	private String publication;
	private int year;
	private Integer pageCount;
	private int bookCopyCount;
	private Set<Author> authors = new HashSet<Author>(0);
	private Set<BookCopyReader> bookCopyReaders = new HashSet<BookCopyReader>(0);
	private Set<BookCopy> bookCopies = new HashSet<BookCopy>(0);

	public Book() {
	}

	public Book(long isbn, String name, int bookCopyCount) {
		this.isbn = isbn;
		this.name = name;
		this.bookCopyCount = bookCopyCount;
	}

	public Book(long isbn, Author author, String name, String publication, int year, Integer pageCount,
			int bookCopyCount, Set<Author> authors, Set<BookCopyReader> bookCopyReaders, Set<BookCopy> bookCopies) {
		if (year < 1700 || year > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Year must be in range [1700 - current year].");
		}
		
		this.isbn = isbn;
		this.author = author;
		this.name = name;
		this.publication = publication;
		this.year = year;
		this.pageCount = pageCount;
		this.bookCopyCount = bookCopyCount;
		this.authors = authors;
		this.bookCopyReaders = bookCopyReaders;
		this.bookCopies = bookCopies;
	}

	@Id
	@Column(name = "isbn", unique = true, nullable = false)
	public long getIsbn() {
		return this.isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "publication", length = 20)
	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Column(name = "year")
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		if (year < 1700 || year > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Year must be in range [1700 - current year].");
		}
		
		this.year = year;
	}

	@Column(name = "page_count")
	public Integer getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	@Column(name = "book_copy_count", nullable = false)
	public int getBookCopyCount() {
		return this.bookCopyCount;
	}

	public void setBookCopyCount(int bookCopyCount) {
		this.bookCopyCount = bookCopyCount;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bookauthors")
	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<BookCopyReader> getBookCopyReaders() {
		return this.bookCopyReaders;
	}

	public void setBookCopyReaders(Set<BookCopyReader> bookCopyReaders) {
		this.bookCopyReaders = bookCopyReaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<BookCopy> getBookCopies() {
		return this.bookCopies;
	}

	public void setBookCopies(Set<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

}
