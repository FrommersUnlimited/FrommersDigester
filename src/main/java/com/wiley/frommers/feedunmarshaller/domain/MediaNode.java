/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.Set;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Node version of Media 
 */
@XStreamAlias("mediaNode")
public class MediaNode {
    
    @XStreamAsAttribute private Long id;
    @XStreamAsAttribute private String name;
    @XStreamAsAttribute private String credit;
    @XStreamAsAttribute private String copyright;
    @XStreamAsAttribute private String caption;
    @XStreamAsAttribute private String keywords;
    
    @XStreamAlias("mediaItems") private Set<MediaItem> mediaItems;

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(Set<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

}
