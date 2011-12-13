/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Summary result node
 * 
 * @author fzerdoudi
 * 
 */
@XStreamAlias("audienceInterestResult")
public class AudienceInterestResult implements SearchResult {
    @XStreamAsAttribute()
    private long id;
    @XStreamAsAttribute()
    private String name;

    @XStreamAlias("children")
    private List<AudienceInterestResult> children;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AudienceInterestResult> getChildren() {
        return children;
    }

    public void setChildren(List<AudienceInterestResult> poiSammary) {
        this.children = poiSammary;
    }
}
