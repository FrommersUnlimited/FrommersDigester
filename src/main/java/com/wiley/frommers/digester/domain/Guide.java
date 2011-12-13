/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A guide representation.
 * 
 * @author tpatel, created 08 June 2009
 */
@XStreamAlias("guide")
public class Guide {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;
    @XStreamAlias("guideType")
    private GuideType guideType;

    @XStreamAlias("guideStructureNodes")
    private List<GuideStructureNode> guideStructureNodes;
    @XStreamAlias("book")
    private Book book;
    @XStreamAlias("locationNode")
    private LocationNode location;
    @XStreamAsAttribute
    private String whatsonwhenId;
    @XStreamAsAttribute
    private Long frommersId;
    @XStreamAlias("parent")
    private GuideNode parent;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocationNode getLocation() {
        return location;
    }

    public void setLocations(LocationNode location) {
        this.location = location;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuideType getGuideType() {
        return guideType;
    }

    public void setGuideType(GuideType guideType) {
        this.guideType = guideType;
    }

    public List<GuideStructureNode> getGuideStructureNodes() {
        return guideStructureNodes;
    }

    public void setGuideStructureNodes(
            List<GuideStructureNode> guideStructureNodes) {
        this.guideStructureNodes = guideStructureNodes;
    }

    public String getWhatsonwhenId() {
        return whatsonwhenId;
    }

    public void setWhatsonwhenId(String whatsonwhenId) {
        this.whatsonwhenId = whatsonwhenId;
    }

    public Long getFrommersId() {
        return frommersId;
    }

    public void setFrommersId(Long frommersId) {
        this.frommersId = frommersId;
    }

    public GuideNode getParent() {
        return parent;
    }

    public void setParent(GuideNode parent) {
        this.parent = parent;
    }
}
