package com.wiley.frommers.digester.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Summary result node
 * 
 * @author faris
 * 
 */
@XStreamAlias("audienceInterestResult")
public class AudienceInterestResult implements SearchResult {
    @XStreamAsAttribute()
    private long id;
    @XStreamAsAttribute()
    private String name;
    @XStreamOmitField
    private long parentId;
    @XStreamAsAttribute()
    private int eventCount;

    @XStreamAsAttribute()
    private int poiCount;

    public int getEventCount() {
        return eventCount;
    }
    
    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getPoiCount() {
        return poiCount;
    }

    public void setPoiCount(int poiCount) {
        this.poiCount = poiCount;
    }

    @XStreamAlias("children")
    private List<AudienceInterestResult> children;

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
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
