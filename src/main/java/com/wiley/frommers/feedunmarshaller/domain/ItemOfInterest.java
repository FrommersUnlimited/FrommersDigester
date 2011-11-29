/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * An IOI (ItemOfInterest) is either an Event or POI as they share many same
 * attributes.
 * 
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("itemOfInterest")
public class ItemOfInterest {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    @XStreamAlias("type")
    private String typeCode;
    @XStreamAsAttribute
    @XStreamAlias("subType")
    private String subTypeCode;
    @XStreamAsAttribute
    @XStreamAlias("extendedType")
    private String extendedTypeCode;
    @XStreamAsAttribute
    private String typeName;
    @XStreamAsAttribute
    private String subTypeName;
    @XStreamAsAttribute
    private String extendedTypeName;

    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String cost;
    @XStreamAsAttribute
    private String openingHours;
    @XStreamAsAttribute
    private String displayDate;
    @XStreamAsAttribute
    private Long rankId;
    @XStreamAsAttribute
    private String rankName;
    @XStreamAsAttribute
    private String priceCategoryCode;
    @XStreamAsAttribute
    private String priceCategoryName;

    private String summary;
    private String description;

    @XStreamAlias("locationInfos")
    private Set<ItemOfInterestLocation> locations;
    @XStreamAlias("audienceInterests")
    private Set<AudienceInterest> audienceInterests;
    @XStreamAlias("medias")
    private Set<MediaNode> medias;
    @XStreamAlias("fields")
    private Set<ItemOfInterestExtraField> extraFields;
    @XStreamAlias("links")
    private Set<UrlLink> links;
    @XStreamAlias("dateRanges")
    private List<DateRange> dateRanges;

    @XStreamAlias("contactInfo")
    private ContactInfo contactInfo;

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Set<AudienceInterest> getAudienceInterests() {
        return audienceInterests;
    }

    public void setAudienceInterests(
            List<AudienceInterest> audienceInterestsList) {
        this.audienceInterests = new HashSet<AudienceInterest>(
                audienceInterestsList);
    }

    public boolean addAudienceInterest(AudienceInterest audienceInterest) {
        return this.audienceInterests.add(audienceInterest);
    }

    public boolean removeAudienceInterest(AudienceInterest audienceInterest) {
        return this.audienceInterests.remove(audienceInterest);
    }

    public Set<ItemOfInterestLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<ItemOfInterestLocation> locationsList) {
        this.locations = new HashSet<ItemOfInterestLocation>(locationsList);
    }

    public boolean addLocation(ItemOfInterestLocation location) {
        return this.locations.add(location);
    }

    public boolean removeLocation(ItemOfInterestLocation location) {
        return this.locations.remove(location);
    }

    public Set<MediaNode> getMedias() {
        return medias;
    }

    public void setMedias(Set<MediaNode> medias) {
        this.medias = medias;
    }

    public void setMedias(List<MediaNode> mediasList) {
        this.medias = new HashSet<MediaNode>(mediasList);
    }

    public boolean addMediaNode(MediaNode mediaNode) {
        return this.medias.add(mediaNode);
    }

    public boolean removeMediaNode(MediaNode mediaNode) {
        return this.medias.remove(mediaNode);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ItemOfInterestExtraField> getExtraFields() {
        return extraFields;
    }

    public void setExtraFields(List<ItemOfInterestExtraField> extraFields) {
        this.extraFields = new HashSet<ItemOfInterestExtraField>(extraFields);
    }

    public List<DateRange> getDateRanges() {
        return dateRanges;
    }

    public void setDateRanges(List<DateRange> dateRanges) {
        this.dateRanges = dateRanges;
    }

    public boolean addDateRange(DateRange dateRange) {
        return this.dateRanges.add(dateRange);
    }

    public boolean removeDateRange(DateRange dateRange) {
        return this.dateRanges.remove(dateRange);
    }

    public Set<UrlLink> getLinks() {
        return links;
    }

    public void setLinks(Set<UrlLink> links) {
        this.links = links;
    }

    public void setLinks(List<UrlLink> linksList) {
        this.links = new HashSet<UrlLink>(linksList);
    }

    public void setAudienceInterests(Set<AudienceInterest> audienceInterests) {
        this.audienceInterests = audienceInterests;
    }

    public void setLocations(Set<ItemOfInterestLocation> locations) {
        this.locations = locations;
    }

    public void setExtraFields(Set<ItemOfInterestExtraField> extraFields) {
        this.extraFields = extraFields;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public String getExtendedTypeName() {
        return extendedTypeName;
    }

    public void setExtendedTypeName(String extendedTypeName) {
        this.extendedTypeName = extendedTypeName;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getPriceCategoryCode() {
        return priceCategoryCode;
    }

    public void setPriceCategoryCode(String priceCategoryCode) {
        this.priceCategoryCode = priceCategoryCode;
    }

    public String getPriceCategoryName() {
        return priceCategoryName;
    }

    public void setPriceCategoryName(String priceCategoryName) {
        this.priceCategoryName = priceCategoryName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public String getExtendedTypeCode() {
        return extendedTypeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public void setExtendedTypeCode(String extendedTypeCode) {
        this.extendedTypeCode = extendedTypeCode;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
