/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.wiley.frommers.digester.domain.util.FriendlyDoubleConverter;

/**
 * Description
 *
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("location")
public class Location {
    
    @XStreamAsAttribute private Long id;
    @XStreamAsAttribute @XStreamAlias("type") private String typeCode;
    @XStreamAsAttribute private String typeName;
    @XStreamAlias("parent") private LocationNode parent;
    
    @XStreamAlias("links") private Set<UrlLink> locationLinks;
    @XStreamAlias("mappings") private Set<LocationMapping> locationMappings;
    @XStreamAlias("recommendations") private Set<Recommendation> recommendations;
    
    @XStreamAsAttribute private String name;
    
    @XStreamImplicit
    private List<Address> addresses;    
    
    @XStreamAsAttribute private Integer accuracy;

    @XStreamAsAttribute private String transportation;
    @XStreamAsAttribute private String locationInfo;

    @XStreamAsAttribute private String closed;
    
    @XStreamAsAttribute @XStreamConverter(FriendlyDoubleConverter.class) private Double latitude;
    @XStreamAsAttribute @XStreamConverter(FriendlyDoubleConverter.class) private Double longitude;
    
    private String description;    

    @XStreamAlias("audienceInterests") private Set<AudienceInterest> audienceInterests;    
    @XStreamAsAttribute private Long whatsonwhenId;
    @XStreamAsAttribute private Long whatsonwhenTouristOfficeId;
    @XStreamAsAttribute private Long frommersAccommodationId;
    @XStreamAsAttribute private Long frommersAttractionId;
    @XStreamAsAttribute private Long frommersDiningId;
    @XStreamAsAttribute private Long frommersNightlifeId;
    @XStreamAsAttribute private Long frommersShoppingId;
    @XStreamAsAttribute private Long frommersDestinationId;

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
    public Long getWhatsonwhenId() {
        return whatsonwhenId;
    }
    public void setWhatsonwhenId(Long whatsonwhenId) {
        this.whatsonwhenId = whatsonwhenId;
    }
    public Long getWhatsonwhenTouristOfficeId() {
        return whatsonwhenTouristOfficeId;
    }
    public void setWhatsonwhenTouristOfficeId(Long whatsonwhenTouristOfficeId) {
        this.whatsonwhenTouristOfficeId = whatsonwhenTouristOfficeId;
    }
    public Long getFrommersAccommodationId() {
        return frommersAccommodationId;
    }
    public void setFrommersAccommodationId(Long frommersAccommodationId) {
        this.frommersAccommodationId = frommersAccommodationId;
    }
    public Long getFrommersAttractionId() {
        return frommersAttractionId;
    }
    public void setFrommersAttractionId(Long frommersAttractionId) {
        this.frommersAttractionId = frommersAttractionId;
    }
    public Long getFrommersDiningId() {
        return frommersDiningId;
    }
    public void setFrommersDiningId(Long frommersDiningId) {
        this.frommersDiningId = frommersDiningId;
    }
    public Long getFrommersNightlifeId() {
        return frommersNightlifeId;
    }
    public void setFrommersNightlifeId(Long frommersNightlifeId) {
        this.frommersNightlifeId = frommersNightlifeId;
    }
    public Long getFrommersShoppingId() {
        return frommersShoppingId;
    }
    public void setFrommersShoppingId(Long frommersShoppingId) {
        this.frommersShoppingId = frommersShoppingId;
    }
    public Long getFrommersDestinationId() {
        return frommersDestinationId;
    }
    public void setFrommersDestinationId(Long frommersDestinationId) {
        this.frommersDestinationId = frommersDestinationId;
    }
    public void setLocationLinks(Set<UrlLink> locationLinks) {
        this.locationLinks = locationLinks;
    }
    public Set<LocationMapping> getLocationMappings() {
        return locationMappings;
    }
    public void setLocationMappings(List<LocationMapping> locationMappings) {
        this.locationMappings = new HashSet<LocationMapping>(locationMappings);
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
    
    public Set<Recommendation> getRecommendations() {
        return recommendations;
    }
    public void setRecommendations(Set<Recommendation> recommendations) {
        this.recommendations = recommendations;
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
    public final List<Address> getAddresses() {
        return addresses;
    }
    public final void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    
}
