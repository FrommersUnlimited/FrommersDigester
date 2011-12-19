/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A type for a given item of interest
 *
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("itemOfInterestType")
public class ItemOfInterestType {
    
    @XStreamAsAttribute private Long id;
    @XStreamAsAttribute private String name;
    @XStreamAsAttribute private String code;

    @XStreamAlias("parent") private ItemOfInterestType parent;
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ItemOfInterestType getParent() {
        return parent;
    }

    public void setParent(ItemOfInterestType parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
