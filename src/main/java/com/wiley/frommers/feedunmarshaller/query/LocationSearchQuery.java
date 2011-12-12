/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class LocationSearchQuery extends PaginatedFeedQuery {

    public LocationSearchQuery() {
        super();
        showMax(false);

    }

    public static String LOCATION_ID_PARAM_NAME = "locationId";

    public void setLocationId(String id) {
        queryParams.put(LOCATION_ID_PARAM_NAME, id);
    }

    public String getLocationId() {
        return queryParams.get(LOCATION_ID_PARAM_NAME);
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
