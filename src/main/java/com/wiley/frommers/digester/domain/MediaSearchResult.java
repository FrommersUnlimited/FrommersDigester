package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Media search result.
 */
@XStreamAlias("mediaResult")
public class MediaSearchResult implements SearchResult {

    @XStreamAsAttribute
    private Long   id;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String credit;
    @XStreamAsAttribute
    private String copyright;
    @XStreamAsAttribute
    private String caption;
    @XStreamAsAttribute
    private String keywords;
    @XStreamAsAttribute
    private String thumbnailMimeType;
    @XStreamAsAttribute
    private Long   thumbnailHeight;
    @XStreamAsAttribute
    private Long   thumbnailWidth;
    @XStreamAsAttribute
    private String thumbnailUrl;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCredit() {
        return credit;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getCaption() {
        return caption;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getThumbnailMimeType() {
        return thumbnailMimeType;
    }

    public Long getThumbnailHeight() {
        return thumbnailHeight;
    }

    public Long getThumbnailWidth() {
        return thumbnailWidth;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

}
