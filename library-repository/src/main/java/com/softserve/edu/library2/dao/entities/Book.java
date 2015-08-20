/**
 *
 */
package com.softserve.edu.library2.dao.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vova
 */

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private int isbn;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String publication;

    private Date year;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "book_copy_count ")
    private int bookCopyCount;

    @Column(name = "author_id")
    private int authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="Subauthor",
            joinColumns = @JoinColumn(name="isbn", referencedColumnName="isbn"),
            inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName="author_id")
    )
    private Set<Author> subauthors = new HashSet<Author>();

    public Book (){}

    public Book (int isbn ,String name, String publication, Date year, int pageCount, int bookCopyCount, int authorId){ }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBookCopyCount() {
        return bookCopyCount;
    }

    public void setBookCopyCount(int bookCopyCount) {
        this.bookCopyCount = bookCopyCount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "year", length = 0)
    public Date getYear() {
        return this.year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublication() {

        return publication;

    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getIsbn() {

        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public Set<Author> getSubauthors() {
        return subauthors;
    }

    public void setSubauthors(Set<Author> subauthors) {
        this.subauthors = subauthors;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
