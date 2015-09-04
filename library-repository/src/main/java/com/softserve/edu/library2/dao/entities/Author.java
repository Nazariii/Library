package com.softserve.edu.library2.dao.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 */
@Entity
@Table(name = "author", catalog = "library")
public class Author implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5868579823661514216L;
	private Integer authorId;
	private String firstName;
	private String lastName;
	private Set<Book> bookauthors = new HashSet<Book>(0);
	private Set<Book> book = new HashSet<Book>(0);

	public Author() {
	}

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(String firstName, String lastName, Set<Book> bookauthors, Set<Book> book) {
		this(firstName, lastName);
		this.bookauthors = bookauthors;
		this.book = book;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "author_id", unique = true, nullable = false)
	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Column(name = "first_name", length = 30)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 30)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subauthor", catalog = "library", joinColumns = { @JoinColumn(name = "author_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "isbn", nullable = false, updatable = false) })
	public Set<Book> getBookauthors() {
		return this.bookauthors;
	}

	public void setBookauthors(Set<Book> books) {
		this.bookauthors = books;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	public Set<Book> getBook() {
		return this.book;
	}

	public void setBook(Set<Book> books_1) {
		this.book = books_1;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(authorId).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Author) {
			final Author other = (Author) obj;
			return new EqualsBuilder().append(authorId, other.authorId).isEquals();
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("authorId", authorId).append("firstName", firstName)
				.append("lastName", lastName).toString();
	}
}
