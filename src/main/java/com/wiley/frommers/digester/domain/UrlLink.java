/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Description
 *
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("link")
public class UrlLink {
    
    @XStreamAsAttribute private String url;
    @XStreamAsAttribute private String name;
    private String description;
    
    public String getUrl() {
        return url;
    }
    public void setUrl(final String url) {
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
