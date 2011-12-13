/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * The type of Guide, e.g. "Frommer's Day By Day Guide"
 * 
 * @see Guide
 * @author tpatel, created 08 June 2009
 */
@XStreamAlias("guideType")
public class GuideType {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String guideGroup;

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

    public String getGuideGroup() {
        return guideGroup;
    }

    public void setGuideGroup(String guideGroup) {
        this.guideGroup = guideGroup;
    }

}
