/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Class representing a Slideshow, complete with slides etc.
 * 
 * @author rwatts, created 8 Aug 2011
 */
@XStreamAlias("slideshow")
public class Slideshow {

    @XStreamAsAttribute
    private Long                    id;
    @XStreamAsAttribute
    private String                  name;
    @XStreamAsAttribute
    private String                  description;

    @XStreamAlias("slides")
    private List<Slide>             slides;
    @XStreamAlias("audienceInterests")
    private Set<AudienceInterest>   audienceInterests;
    @XStreamAlias("locations")
    private Set<LocationNode>       locationNodes;
    @XStreamAlias("guides")
    private Set<GuideNode>          guideNodes;
    @XStreamAlias("guideStructures")
    private Set<GuideStructureNode> guideStructureNodes;
    @XStreamAsAttribute 
    private int                     slideCount;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<LocationNode> getLocationNodes() {
        return locationNodes;
    }

    public void setLocationNodes(Set<LocationNode> locationNodes) {
        this.locationNodes = locationNodes;
    }

    public Set<GuideNode> getGuideNodes() {
        return guideNodes;
    }

    public void setGuideNodes(Set<GuideNode> guideNodes) {
        this.guideNodes = guideNodes;
    }

    public Set<GuideStructureNode> getGuideStructureNodes() {
        return guideStructureNodes;
    }

    public void setGuideStructureNodes(Set<GuideStructureNode> guideStructureNodes) {
        this.guideStructureNodes = guideStructureNodes;
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSlideCount() {
        return slideCount;
    }
    
    public void setSlideCount(int slideCount) {
        this.slideCount = slideCount;
    }
}
