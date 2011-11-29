/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * An IOI's Location can be different depending on what type of IOI it is. If
 * the IOI is in fact a POI it has a direct relationship with Location (as it is
 * one). If the IOI is actually an Event then it can occur at many locations.
 * 
 * @author rwatts, created 15 Mar 2010
 */
@XStreamAlias("locationInfo")
public class ItemOfInterestLocation {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String locationType;
    @XStreamAsAttribute
    private String locationTypeName;
    @XStreamAsAttribute
    private Double longitude;
    @XStreamAsAttribute
    private Double latitude;

    private Address address;
    private LocationNode parent;

    @XStreamImplicit
    private Set<UrlLink> links;

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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public final Address getAddress() {
        return address;
    }

    public final void setAddresses(Address address) {
        this.address = address;
    }

    public LocationNode getParent() {
        return parent;
    }

    public void setParent(LocationNode parent) {
        this.parent = parent;
    }

    public Set<UrlLink> getLinks() {
        return links;
    }

    public void setLinks(Set<UrlLink> links) {
        this.links = links;
    }

}
