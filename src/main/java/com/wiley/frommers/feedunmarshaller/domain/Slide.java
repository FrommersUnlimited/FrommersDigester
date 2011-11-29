/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;


/**
 * Class representing a Slide
 *
 * @author rwatts, created 8 Aug 2011
 */
@XStreamAlias("slide")
public class Slide {
    
    @XStreamAsAttribute private Long id;
    @XStreamAsAttribute private Media media;
    @XStreamAsAttribute private String name;
    @XStreamAsAttribute @XStreamAlias("text") private String caption;
    @XStreamAsAttribute private String altText;
    @XStreamAsAttribute private Long number;

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCaption() {
        return caption;
    }
    
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public String getAltText() {
        return altText;
    }
    
    public void setAltText(String altText) {
        this.altText = altText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
