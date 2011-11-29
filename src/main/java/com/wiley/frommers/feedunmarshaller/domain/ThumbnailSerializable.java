package com.wiley.frommers.feedunmarshaller.domain;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Bean for contain Media fields.
 * 
 * @author ikornilov
 * 
 */
@XStreamAlias("image")
public class ThumbnailSerializable implements Serializable {
    private static final long serialVersionUID = -8725144430215949557L;

    @XStreamAsAttribute
    @XStreamAlias("mediaId")
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
