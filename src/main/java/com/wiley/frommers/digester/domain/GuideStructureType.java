/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A GuideStructureType is a classfication for GuideStructure. E.g.
 * "Introduction" or "Getting Around" and can be used across a given Guide.
 * 
 * @see GuideStructure
 * @see Guide
 * @author tpatel, created 08 June 2009
 */
@XStreamAlias("guideStructureType")
public class GuideStructureType {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;

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
}
