/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;

/**
 * Description
 * 
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("location")
public class Location {

    public static final String CONTINENT = "CONTINENT";

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    @XStreamAlias("type")
    private String typeCode;
    @XStreamAsAttribute
    private String typeName;
    @XStreamAlias("parent")
    private LocationNode parent;

    @XStreamAlias("links")
    private Set<UrlLink> locationLinks;

    @XStreamAlias("mappings")
    private Set<LocationMapping> locationMappings;
    @XStreamAlias("recommendations")
    private Set<Recommendation> recommendations;

    @XStreamAsAttribute
    private String name;

    @XStreamAsAttribute
    private Integer accuracy;

    @XStreamAsAttribute
    private String transportation;
    @XStreamAsAttribute
    private String locationInfo;

    @XStreamAsAttribute
    private String closed;

    private String nameCode;

    @XStreamAsAttribute
    @XStreamConverter(DoubleConverter.class)
    private Double latitude;
    @XStreamAsAttribute
    @XStreamConverter(DoubleConverter.class)
    private Double longitude;

    private String description;

    @XStreamAlias("audienceInterests")
    private Set<AudienceInterest> audienceInterests;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocationNode getParent() {
        return parent;
    }

    public void setParent(LocationNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Set<UrlLink> getLocationLinks() {
        return locationLinks;
    }

    public void setLocationLinks(List<UrlLink> locationLinks) {
        this.locationLinks = new HashSet<UrlLink>(locationLinks);
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public void setLocationLinks(Set<UrlLink> locationLinks) {
        this.locationLinks = locationLinks;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AudienceInterest> getAudienceInterests() {
        return audienceInterests;
    }

    public void setAudienceInterests(Set<AudienceInterest> audienceInterests) {
        this.audienceInterests = audienceInterests;
    }

    public Set<LocationMapping> getLocationMappings() {
        return locationMappings;
    }

    public void setLocationMappings(Set<LocationMapping> locationMappings) {
        this.locationMappings = locationMappings;
    }

    public Set<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Set<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

}
