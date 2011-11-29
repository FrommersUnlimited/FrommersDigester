package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * An image is provided in search feeds as a pointer to a Media
 * 
 * @see Media
 * @author ikornilov
 */
@XStreamAlias("image")
public class Image {

    @XStreamAsAttribute
    private Long mediaId;
    @XStreamAsAttribute
    private String mediaUrl;
    @XStreamAsAttribute
    private String mimeType;
    @XStreamAsAttribute
    private int width;
    @XStreamAsAttribute
    private int height;
    @XStreamAsAttribute
    private String credit;
    @XStreamAsAttribute
    private String copyright;
    @XStreamAsAttribute
    private String caption;
    @XStreamOmitField
    private String keywords;

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
