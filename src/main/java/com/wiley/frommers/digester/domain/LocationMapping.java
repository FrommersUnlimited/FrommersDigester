/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Location mapping class
 * 
 * @author Sachin Katakdound(skatakdoun), created Mar 31, 2010
 */
@XStreamAlias("mapping")
public class LocationMapping {

    @XStreamAsAttribute
    private String type;

    @XStreamAsAttribute
    private String id;

    @XStreamAsAttribute
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
