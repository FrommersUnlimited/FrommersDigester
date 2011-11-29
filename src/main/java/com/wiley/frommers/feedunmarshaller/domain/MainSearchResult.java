/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Description
 * 
 * @author rwatts, created 10 Sep 2009
 */
@XStreamAlias("mainResult")
public class MainSearchResult implements SearchResult {

    @XStreamAsAttribute()
    private Long id;
    @XStreamAsAttribute()
    private String name;
    @XStreamAsAttribute()
    private String type;
    @XStreamAsAttribute()
    private String typeName;
    @XStreamAsAttribute()
    private String subType;
    @XStreamAsAttribute()
    private String subTypeName;
    @XStreamAsAttribute()
    private String neighborhood;
    @XStreamAsAttribute()
    private String city;
    @XStreamAsAttribute()
    private String country;
    @XStreamAsAttribute()
    private Double longitude;
    @XStreamAsAttribute()
    private Double latitude;

    private Image image;
    private String summary;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

}