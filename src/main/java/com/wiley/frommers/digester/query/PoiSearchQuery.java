/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class PoiSearchQuery extends LocationSearchQuery {

    public PoiSearchQuery() {
        super();
        // showMax(true);
        setNPerPage(50);
    }

    public void setType(String type) {
        queryParams.put("type", type);
    }

    public String getType() {
        return queryParams.get("type");
    }

}
