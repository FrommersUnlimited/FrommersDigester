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
 * A GuideStructure representation. A GuideStructure represents a section of a
 * guide, which is hierarchical in that it can have a parent GuideStructure.
 * 
 * @see Guide
 * @author tpatel, created 08 June 2009
 */
@XStreamAlias("guideStructure")
public class GuideStructure {

    @XStreamAsAttribute
    private Long id;
    @XStreamAlias("guide")
    private Guide guide;
    @XStreamAlias("parent")
    private GuideStructureNode parent;
    @XStreamAlias("guideStructureType")
    private GuideStructureType guideStructureType;

    private String content;

    @XStreamAlias("relatedItemOfInterests")
    private Set<ItemOfInterestNode> relatedItemOfInterests;
    @XStreamAlias("medias")
    private Set<MediaNode> medias;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public GuideStructureNode getParent() {
        return parent;
    }

    public void setParent(GuideStructureNode parent) {
        this.parent = parent;
    }

    public GuideStructureType getGuideStructureType() {
        return guideStructureType;
    }

    public void setGuideStructureType(GuideStructureType guideStructureType) {
        this.guideStructureType = guideStructureType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRelatedItemOfInterests(
            List<ItemOfInterestNode> relatedItemOfInterests) {
        this.relatedItemOfInterests = new HashSet<ItemOfInterestNode>(
                relatedItemOfInterests);
    }

    public Set<ItemOfInterestNode> getRelatedItemOfInterests() {
        return relatedItemOfInterests;
    }

    public Set<MediaNode> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaNode> medias) {
        this.medias = new HashSet<MediaNode>(medias);
    }

}
