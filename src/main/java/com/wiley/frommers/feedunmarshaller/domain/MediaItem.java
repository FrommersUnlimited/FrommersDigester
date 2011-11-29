/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A MediaItem is a "rendition" of a Media object. Media objects can have multiple MediaItem
 * representing say an image at different sizes.
 * 
 * @author rwatts, created 8 Aug 2011
 */
@XStreamAlias("mediaItem")
public class MediaItem {

    @XStreamAsAttribute @XStreamAlias("type") private String typeCode;
    @XStreamAsAttribute private String url;
    @XStreamAsAttribute private Long height;
    @XStreamAsAttribute private Long width;
    @XStreamAsAttribute private String mimeType;
    
    public String getTypeCode() {
        return typeCode;
    }
    
    public void setTypeCode(String typeCd) {
        this.typeCode = typeCd;
    }
    
    public Long getHeight() {
        return height;
    }
    
    public void setHeight(Long height) {
        this.height = height;
    }
    
    public Long getWidth() {
        return width;
    }
    
    public void setWidth(Long width) {
        this.width = width;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
