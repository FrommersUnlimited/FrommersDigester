/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Represent actual feed result for POI
 * 
 * @author Sachin Katakdound(skatakdoun), created Feb 1, 2010
 */
@XStreamAlias("poiResult")
public class POISearchResult extends MainSearchResult {
    @XStreamAsAttribute() private Long rankId;
    @XStreamAsAttribute() private String priceCategory;
    @XStreamAsAttribute() private String extendedInfo;
    @XStreamAsAttribute() private String extendedInfoType;
    

    public Long getRankId() {
        return rankId;
    }

    public void setRank(Long rankId) {
        this.rankId = rankId;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }
    
    public String getExtendedInfo() {
        return extendedInfo;
    }

    public void setExtendedInfo(String extendedInfo) {
        this.extendedInfo = extendedInfo;
    }

    public String getExtendedInfoType() {
        return extendedInfoType;
    }

    public void setExtendedInfoType(String extendedInfoType) {
        this.extendedInfoType = extendedInfoType;
    }
}
