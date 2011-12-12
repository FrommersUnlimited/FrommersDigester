/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class PoiQuery extends LocationQuery {

    public PoiQuery() {
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
