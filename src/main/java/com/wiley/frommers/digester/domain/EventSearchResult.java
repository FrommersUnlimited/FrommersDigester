/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Representation of a event based search result.
 * 
 * @author ikornilov, created 01 Sep 2010
 */
@XStreamAlias("eventResult")
public class EventSearchResult extends MainSearchResult {

    @XStreamAsAttribute()
    private Long rankId;
    @XStreamAsAttribute()
    private String displayDate;
    @XStreamAsAttribute()
    private String displayLocation;

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

}