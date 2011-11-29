/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A simple representation of a item of interest just by Id and Name.
 * 
 * @author rwatts, created 28 Aug 2009
 */
@XStreamAlias("itemOfInterestNode")
public class ItemOfInterestNode {

    @XStreamAsAttribute()
    private Long id;
    @XStreamAsAttribute()
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
