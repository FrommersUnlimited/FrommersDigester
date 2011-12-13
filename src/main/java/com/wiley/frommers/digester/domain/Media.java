/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Media class, containing "renditions" in the form of MediaItem objects.
 */
@XStreamAlias("media")
public class Media {

    @XStreamAsAttribute private Long id;
    @XStreamAsAttribute private String name;
    @XStreamAsAttribute private String credit;
    @XStreamAsAttribute private String copyright;
    @XStreamAsAttribute private String caption;
    @XStreamAsAttribute private String keywords;
    
    @XStreamAlias("mediaItems")         private Set<MediaItem>          mediaItems;
    @XStreamAlias("audienceInterests")  private Set<AudienceInterest>   audienceInterests;
    @XStreamAlias("locations")          private Set<LocationNode>       locationNodes;
    @XStreamAlias("guideStructures")    private Set<GuideStructureNode> guideStructureNodes;
    @XStreamAlias("guides")             private Set<GuideNode>          guideNodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(Set<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public Set<AudienceInterest> getAudienceInterests() {
        return audienceInterests;
    }

    public void setAudienceInterests(Set<AudienceInterest> audienceInterests) {
        this.audienceInterests = audienceInterests;
    }

    public Set<LocationNode> getLocationNodes() {
        return locationNodes;
    }

    public void setLocationNodes(Set<LocationNode> locationNodes) {
        this.locationNodes = locationNodes;
    }

    public Set<GuideStructureNode> getGuideStructureNodes() {
        return guideStructureNodes;
    }

    public void setGuideStructureNodes(Set<GuideStructureNode> guideStructureNodes) {
        this.guideStructureNodes = guideStructureNodes;
    }

    public Set<GuideNode> getGuideNodes() {
        return guideNodes;
    }

    public void setGuideNodes(Set<GuideNode> guideNodes) {
        this.guideNodes = guideNodes;
    }

}
