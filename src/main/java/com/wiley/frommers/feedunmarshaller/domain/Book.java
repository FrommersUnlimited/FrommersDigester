/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A Book is attached a to a Guide
 * 
 * @see Guide
 * @author rwatts, created 08 June 2009
 */
@XStreamAlias("book")
public class Book {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String title;
    @XStreamAsAttribute
    private String subTitle;
    @XStreamAsAttribute
    private String isbn;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
