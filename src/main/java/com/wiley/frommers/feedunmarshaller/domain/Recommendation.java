/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Location mapping class
 * 
 * @author Sachin Katakdound(skatakdoun), created Mar 31, 2010
 */
@XStreamAlias("recommendation")
public class Recommendation {
    
    @XStreamAsAttribute() private int strength;
    @XStreamAsAttribute() private String type;
    @XStreamAsAttribute() private String typeName;
    @XStreamAsAttribute() private String review;

    private AudienceInterest audienceInterest;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public AudienceInterest getAudienceInterest() {
        return audienceInterest;
    }
    public void setAudienceInterest(AudienceInterest audienceInterest) {
        this.audienceInterest = audienceInterest;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
}
