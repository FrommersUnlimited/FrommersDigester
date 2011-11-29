/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A DestinationMenu provides links to available content for a particular
 * location. It presents the links in a hierarchical manner to help menu
 * building.
 * 
 * @author rwatts, created 20 Nov 2009
 */
@XStreamAlias("destinationMenu")
public class DestinationMenu {

    @XStreamAsAttribute()
    private Long locationId;
    @XStreamAsAttribute()
    private String name;
    @XStreamAlias("destinationLinks")
    private List<DestinationLink> destinationLinks;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DestinationLink> getDestinationLinks() {
        return destinationLinks;
    }

    public void setDestinationLinks(List<DestinationLink> destinationLinks) {
        this.destinationLinks = destinationLinks;
    }

}
