/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * A named URL linking to deep content. Can also contain children.
 * 
 * @see DestinationMenu
 * @author rwatts, created 20 Nov 2009
 */
@XStreamAlias("destinationLink")
public class DestinationLink {

    @XStreamAsAttribute()
    private String name;
    @XStreamAsAttribute()
    private String feedCode;
    @XStreamAsAttribute()
    private String feedQuery;
    @XStreamAsAttribute()
    private String url;

    @XStreamOmitField
    private boolean selected;

    @XStreamOmitField
    private boolean childSelected;

    @XStreamAlias("children")
    private List<DestinationLink> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<DestinationLink> getChildren() {
        return children;
    }

    public void setChildren(List<DestinationLink> children) {
        this.children = children;
    }

    public void addChild(DestinationLink child) {
        if (this.children == null) {
            this.children = new ArrayList<DestinationLink>();
        }
        this.children.add(child);
    }

    public void setFeedCode(String feedCode) {
        this.feedCode = feedCode;
    }

    public String getFeedCode() {
        return feedCode;
    }

    public void setFeedQuery(String feedQuery) {
        this.feedQuery = feedQuery;
    }

    public String getFeedQuery() {
        return feedQuery;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isChildSelected() {
        return childSelected;
    }

    public void setChildSelected(boolean childSelected) {
        this.childSelected = childSelected;
    }

}
