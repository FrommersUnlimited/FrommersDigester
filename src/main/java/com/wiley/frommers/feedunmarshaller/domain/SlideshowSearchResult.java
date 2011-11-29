package com.wiley.frommers.feedunmarshaller.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Slideshow search result.
 */
@XStreamAlias("slideshowResult")
public class SlideshowSearchResult implements SearchResult {

    @XStreamAsAttribute
    private Long id;
    @XStreamAsAttribute
    private String type;
    @XStreamAsAttribute
    private String name;

    private String description;

    private ThumbnailSerializable image;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public ThumbnailSerializable getImage() {
        return image;
    }

    public void setImage(ThumbnailSerializable image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

}
