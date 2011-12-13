/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A simple representation of a location just by Id and Name.
 *
 * @author rwatts, created 28 Aug 2009
 */
@XStreamAlias("locationNode")
public class LocationNode {
    
    @XStreamAsAttribute() private Long id;
    @XStreamAsAttribute() private String name;
    @XStreamAlias("parent") private LocationNode parent;
    
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
    public LocationNode getParent() {
        return parent;
    }
    public void setParent(LocationNode parent) {
        this.parent = parent;
    }
    
}
