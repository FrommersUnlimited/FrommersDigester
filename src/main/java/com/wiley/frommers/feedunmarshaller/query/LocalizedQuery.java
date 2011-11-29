/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class LocalizedQuery extends AbstractQuery {

    public static String LOCATION_ID_PARAM_NAME = "locationId";

    public LocalizedQuery() {
        super();
    }

    public void setLocationId(String id) {
        queryParams.put(LOCATION_ID_PARAM_NAME, id);
    }

    public String getLocationId() {
        return queryParams.get(LOCATION_ID_PARAM_NAME);
    }

    public String getId() {
        return getLocationId();
    }
}
