/*
z * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author apometov
 * 
 */
@XStreamAlias("locationResult")
public class LocationSearchResult implements SearchResult {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String typeName;
    @XStreamAsAttribute
    private String type;

    // @XStreamAsAttribute @XStreamConverter(FriendlyDoubleConverter.class)
    // private Double latitude;
    // @XStreamAsAttribute @XStreamConverter(FriendlyDoubleConverter.class)
    // private Double longitude;
    // @XStreamAsAttribute @XStreamConverter(FriendlyDoubleConverter.class)
    // private Double miles;
    //
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String locationTypeName) {
        this.typeName = locationTypeName;
    }

    // public Double getLatitude() {
    // return latitude;
    // }
    //
    // public void setLatitude(Double latitude) {
    // this.latitude = latitude;
    // }
    //
    // public Double getLongitude() {
    // return longitude;
    // }
    //
    // public void setLongitude(Double longitude) {
    // this.longitude = longitude;
    // }
    //
    // public Double getMiles() {
    // return miles;
    // }
    //
    // public void setMiles(Double miles) {
    // this.miles = miles;
    // }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
