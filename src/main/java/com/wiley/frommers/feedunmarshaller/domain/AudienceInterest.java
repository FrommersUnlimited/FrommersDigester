/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * An AudienceInterest is a way classify travel entities. They are used to give
 * extra meaning that can be used across different concepts, such as an Event or
 * POI. This is used to show that a given Event and POI, whilst being different,
 * can have a relationship through AudienceInterest.
 * 
 * E.g. an Event and POI can both have an AudienceInterest "Skiing", which could
 * be a child of "Winter Sports".
 * 
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("audienceInterest")
public class AudienceInterest {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;
    @XStreamAlias("parent")
    private AudienceInterest parent;

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

    public AudienceInterest getParent() {
        return parent;
    }

    public void setParent(AudienceInterest parent) {
        this.parent = parent;
    }
}
