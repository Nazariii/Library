package com.softserve.edu.library2.dao.entities;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "book_copy_reader", catalog = "library")
public class BookCopyReader implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3473416867836800803L;
	private BookCopyReaderId id;
	private Book book;
	private BookCopy bookCopy;
	private Reader reader;

	public BookCopyReader() {
	}

	public BookCopyReader(BookCopyReaderId id, Book book, BookCopy bookCopy, Reader reader) {
		this.id = id;
		this.book = book;
		this.bookCopy = bookCopy;
		this.reader = reader;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "readerId", column = @Column(name = "reader_id", nullable = false)),
			@AttributeOverride(name = "isbn", column = @Column(name = "isbn", nullable = false)) })
	public BookCopyReaderId getId() {
		return this.id;
	}

	public void setId(BookCopyReaderId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn", nullable = false, insertable = false, updatable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "book_copy_id", nullable = false)
	public BookCopy getBookCopy() {
		return this.bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reader_id", nullable = false, insertable = false, updatable = false)
	public Reader getReader() {
		return this.reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

}
