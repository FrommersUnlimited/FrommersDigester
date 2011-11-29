/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class LocationQuery extends LocalizedQuery {

    public LocationQuery() {
        super();
        // setNPerPage(100);
        showMax(false);
    }

    public void setLocationType(String type) {
        queryParams.put("type", type);
    }

    public String getLocationType() {
        return queryParams.get("type");
    }

    public void setParentId(String parentId) {
        queryParams.put("parentId", parentId);
    }

    public String getParentId() {
        return queryParams.get("parentId");
    }

}
