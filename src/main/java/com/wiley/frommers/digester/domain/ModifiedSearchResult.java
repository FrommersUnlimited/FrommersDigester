/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Description
 *
 * @author agrigori, created 12 Oct 2009
 */
@XStreamAlias("modifiedResult")
public class ModifiedSearchResult implements SearchResult {
    
    @XStreamAsAttribute private Long id;
    @XStreamAsAttribute private String action;
    @XStreamAsAttribute private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
